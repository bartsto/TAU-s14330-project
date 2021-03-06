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

    @Before
    public void beforeTest() {
        teamServiceImpl.create("Manchester United", "Manchester", "Old Trafford");
        teamServiceImpl.create("Liverpool FC", "Liverpool", "Anfield Road");
        teamServiceImpl.create("Arsenal Londyn", "Arsenal", "Emirates Stadium");
    }

    @Test
    public void teamShouldBeInDb() {
        Assert.assertNotNull(teamServiceImpl.read(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void teamShouldNotBeInDb() throws IllegalArgumentException {
        teamServiceImpl.read(-5);
    }

//    @Test
//    public void teamDataShouldBeUpdated() {
//        Team teamUpdated = new Team("Chelsea Londyn", "Londyn", "Stamford Bridge");
//        teamServiceImpl.update(teamUpdated);
//        Assert.assertEquals(teamServiceImpl.read(0).getCity(), teamUpdated.getCity());
//        Assert.assertEquals(teamServiceImpl.read(0).getName(), teamUpdated.getName());
//        Assert.assertEquals(teamServiceImpl.read(0).getStadium(), teamUpdated.getStadium());
//    }

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

    @Test
    public void teamNameShouldBeFoundByPartialName() {
        Assert.assertEquals("Manchester United", teamServiceImpl.searchFirstTeamByNotFullName("chest"));
        Assert.assertEquals("Manchester United", teamServiceImpl.searchFirstTeamByNotFullName("ted"));
        Assert.assertEquals("Liverpool FC", teamServiceImpl.searchFirstTeamByNotFullName("pool"));
        Assert.assertEquals("No result.", teamServiceImpl.searchFirstTeamByNotFullName("inny tekst"));
    }

    @Test
    public void teamsShouldBeRemovedByProvidedListOfTeamNames() {
        List<String> listOfTeamNamesToRemove = new ArrayList<>();
        listOfTeamNamesToRemove.add("Manchester United");
        listOfTeamNamesToRemove.add("Liverpool FC");

        int sizeBeforeDelete = teamServiceImpl.readAll().size();
        teamServiceImpl.deleteTeamsByProvidedListOfTeamNames(listOfTeamNamesToRemove);
        Assert.assertEquals(sizeBeforeDelete - listOfTeamNamesToRemove.size(), teamServiceImpl.readAll().size());
    }
}
