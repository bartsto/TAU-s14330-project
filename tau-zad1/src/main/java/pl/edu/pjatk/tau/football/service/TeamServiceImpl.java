package pl.edu.pjatk.tau.football.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.repository.TeamRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    private List<Team> db = new ArrayList<>();

    @Override
    public void create(String name, String city, String stadium) {
        Team team = new Team(name, city, stadium);
        teamRepository.save(team);
    }

    @Override
    public Optional<Team> read(int id){
            return teamRepository.findById(id);
    }

    @Override
    public void update(Team team) {
        Optional<Team> teamInDb = teamRepository.findById(team.getId());
        if (teamInDb.isPresent()) {
            Team teamToChange = teamInDb.get();
            teamToChange.setName(team.getName());
            teamToChange.setCity(team.getCity());
            teamToChange.setStadium(team.getStadium());
            teamRepository.save(teamToChange);
        }
    }

    @Override
    public void delete(int id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Team> readAll() {
        return teamRepository.findAll();
    }

    @Override
    public String searchFirstTeamByNotFullName(String partialText) {
        for (Team t : db) {
            if (t.getName().matches("(.*)" + partialText + "(.*)")) {
                return t.getName();
            }
        }
        return "No result.";
    }

    @Override
    public void deleteTeamsByProvidedListOfTeamNames(List<String> listOfTeamsNamesToRemove) {
        List<Integer> listOfIndexesToDelete = new ArrayList<>();
        for (Team t : db) {
            if (listOfTeamsNamesToRemove.contains(t.getName())) {
                listOfIndexesToDelete.add(t.getId());
            }
        }
        for (Integer i : listOfIndexesToDelete) {
            delete(i);
        }
    }
}
