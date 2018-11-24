package pl.edu.pjatk.tau.football.service;

import pl.edu.pjatk.tau.football.domain.Team;
import java.util.ArrayList;
import java.util.List;

public class TeamServiceImpl implements TeamService {

    private List<Team> db = new ArrayList<>();

    @Override
    public void create(int id, String name, String city, String stadium) {
        Team team = new Team(id, name, city, stadium);
        db.add(team);
    }

    @Override
    public Team read(int id) throws IllegalArgumentException{
        for (Team t : db){
            if (t.getId() == id){
                return t; }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void update(Team team) {
        for (Team t : db){
            if (t.getId() == team.getId()){
                t.setName(team.getName());
                t.setCity(team.getCity());
                t.setStadium(team.getStadium());
            }
        }
    }

    @Override
    public void delete(int id) {
        db.remove(id);
    }

    @Override
    public List<Team> readAll() {
        return db;
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
