package pl.edu.pjatk.tau.football;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.service.TeamService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
//@Commit
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class TeamDBUnitTest {

    @Autowired
    TeamService teamService;

    @Test
    @DatabaseSetup("/fullData.xml")
    public void getDatabaseSize() {
        assertEquals(10, teamService.readAll().size());

        teamService.create("WISLA", "Krakow", "Reymonta");

        assertEquals(11, teamService.readAll().size());
    }

    @Test
    @DatabaseSetup("/fullData.xml")
    public void getOneTeam() {
        assertEquals("LECHIA", teamService.read(1000).get().getName());
    }

    @Test
    @DatabaseSetup("/fullData.xml")
    public void updateOneTeam() {
        assertEquals("Warsaw Arena", teamService.read(1003).get().getStadium());

        Team teamUpdated = new Team("Chelsea Londyn", "Londyn", "Stamford Bridge");
        teamService.update(teamUpdated);

        assertEquals(teamService.read(1003).get().getCity(), teamUpdated.getCity());
        assertEquals(teamService.read(1003).get().getName(), teamUpdated.getName());
        assertEquals(teamService.read(1003).get().getStadium(), teamUpdated.getStadium());
    }

    @Test
    @DatabaseSetup("/fullData.xml")
    public void removeOneTeam() {
        assertEquals(10, teamService.readAll().size());

        teamService.delete(1009);

        assertEquals(9, teamService.readAll().size());
    }

    @Test
    @DatabaseSetup("/fullData.xml")
    public void findByName() {
        assertNotNull(teamService.searchFirstTeamByNotFullName("SLA"));
    }

}
