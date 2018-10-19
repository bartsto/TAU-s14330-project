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
    public Team read(int id, List<Team> dbName) throws IllegalArgumentException{
        for (Team t : dbName){
            if (t.getId() == id)
                return t;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void update(Team team, List<Team> dbName) {
        for (Team t : dbName){
            if (t.getId() == team.getId()){
                t.setName(team.getName());
                t.setCity(team.getCity());
                t.setStadium(team.getStadium());
            }
        }
    }

    @Override
    public void delete(int id, List<Team> dbName) {
        dbName.remove(id);
    }
}
