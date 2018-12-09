package pl.edu.pjatk.tau.football.service;

import pl.edu.pjatk.tau.football.domain.Team;
import java.util.List;
import java.util.Optional;

public interface TeamService {

    public void create (String name, String city, String stadium);

    public Optional<Team> read (int id);

    public void update (Team team);

    public void delete (int id);

    public List<Team> readAll ();

    public String searchFirstTeamByNotFullName(String partialText);

    public void deleteTeamsByProvidedListOfTeamNames(List<String> listOfTeamsNamesToRemove);
}
