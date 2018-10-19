package pl.edu.pjatk.tau.football.service;

import pl.edu.pjatk.tau.football.domain.Team;

import java.util.List;

public interface TeamService {

    public void create (int id, String name, String city, String stadium);

    public Team read (int id, List<Team> dbName) throws IllegalArgumentException;

    public void update (Team team, List<Team> dbName);

    public void delete (int id, List<Team> dbName);
}
