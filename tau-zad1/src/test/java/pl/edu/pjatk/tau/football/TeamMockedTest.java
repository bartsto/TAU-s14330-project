package pl.edu.pjatk.tau.football;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.service.TeamServiceImpl;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamMockedTest {

    @Mock
    TeamServiceImpl teamServiceImpl ;

    @Mock
    Team team;

    private LocalDateTime testDateTime = LocalDateTime.now();

    @Test
    public void lastReadTimeShouldBeTheSameAsExpected() {
        when(teamServiceImpl.read(0)).thenReturn(team);
        when(teamServiceImpl.read(0).getLastReadTime()).thenReturn(testDateTime);

        teamServiceImpl.read(0);

        Assert.assertEquals(team.getLastReadTime(), testDateTime);
    }

    @Test
    public void whenCallingCreateMethodWantedNumberOfInvocationsShouldBeEqualToOne() {
        doNothing().when(teamServiceImpl).create(isA(Integer.class), isA(String.class), isA(String.class), isA(String.class));

        teamServiceImpl.create(5,"Tottenham", "Londyn", "Wembley");

        verify(teamServiceImpl, times(1)).create(5,"Tottenham", "Londyn", "Wembley");
    }
}
