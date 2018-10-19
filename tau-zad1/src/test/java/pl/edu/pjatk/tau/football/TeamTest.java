package pl.edu.pjatk.tau.football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.service.TeamServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class TeamTest {

    TeamServiceImpl teamServiceImpl = new TeamServiceImpl();
    List<Team> testDb = new ArrayList<>();
    Team manUtd = new Team(0, "Manchester United", "Manchester", "Old Trafford");
    Team liverpool = new Team (1, "Liverpool FC", "Liverpool", "Anfield Road");
    Team arsenal = new Team (2, "Arsenal Londyn", "Arsenal", "Emirates Stadium");


    @Before
    public void beforeTest() {
        testDb.add(manUtd);
        testDb.add(liverpool);
        testDb.add(arsenal);
    }

    @Test
    public void teamShouldBeInDb() {
        Assert.assertNotNull(teamServiceImpl.read(1, testDb));
        Assert.assertEquals(manUtd, testDb.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamShouldNotBeInDb() throws IllegalArgumentException {
        teamServiceImpl.read(-5, testDb);
    }

    @Test
    public void teamDataShouldBeUpdated() {
        Team teamUpdated = new Team(0, "Chelsea Londyn", "Londyn", "Stamford Bridge");
        teamServiceImpl.update(teamUpdated, testDb);
        Assert.assertEquals(testDb.get(0).getCity(), teamUpdated.getCity());
        Assert.assertEquals(testDb.get(0).getName(), teamUpdated.getName());
        Assert.assertEquals(testDb.get(0).getStadium(), teamUpdated.getStadium());
    }

    @Test
    public void teamShouldBeDeleted() {
        int sizeBeforeDelete = testDb.size();
        teamServiceImpl.delete(2, testDb);
        Assert.assertEquals((sizeBeforeDelete-1), testDb.size());
    }

}
