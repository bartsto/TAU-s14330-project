package pl.edu.pjatk.tau.football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.service.TeamServiceImpl;

import java.util.List;

@RunWith(JUnit4.class)
public class TeamTest {

    TeamServiceImpl teamServiceImpl = new TeamServiceImpl();

    @Before
    public void beforeTest() {
        teamServiceImpl.create(0, "Manchester United", "Manchester", "Old Trafford");
        teamServiceImpl.create(1, "Liverpool FC", "Liverpool", "Anfield Road");
        teamServiceImpl.create(2, "Arsenal Londyn", "Arsenal", "Emirates Stadium");
    }

    @Test
    public void teamShouldBeInDb() {
        Assert.assertNotNull(teamServiceImpl.read(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamShouldNotBeInDb() throws IllegalArgumentException {
        teamServiceImpl.read(-5);
    }

    @Test
    public void teamDataShouldBeUpdated() {
        Team teamUpdated = new Team(0, "Chelsea Londyn", "Londyn", "Stamford Bridge");
        teamServiceImpl.update(teamUpdated);
        Assert.assertEquals(teamServiceImpl.read(0).getCity(), teamUpdated.getCity());
        Assert.assertEquals(teamServiceImpl.read(0).getName(), teamUpdated.getName());
        Assert.assertEquals(teamServiceImpl.read(0).getStadium(), teamUpdated.getStadium());
    }

    @Test
    public void teamShouldBeDeleted() {
        int sizeBeforeDelete = teamServiceImpl.readAll().size();
        teamServiceImpl.delete(2);
        Assert.assertEquals((sizeBeforeDelete-1), teamServiceImpl.readAll().size());
    }

    @Test
    public void readAllShouldReturnAllData() {
        List<Team> testList = teamServiceImpl.readAll();
        Assert.assertNotNull(testList);
        Assert.assertEquals(teamServiceImpl.readAll().size(), testList.size());
    }
}
