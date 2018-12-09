package pl.edu.pjatk.tau.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.tau.football.domain.Team;
import pl.edu.pjatk.tau.football.service.TeamService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> readAllTeams() {
        return teamService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity readOneTeam(@PathVariable("id") int id) {
        Optional<Team> team = teamService.read(id);
        if (team.isPresent()) {
            return ResponseEntity.ok(team);
        } else {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value= "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Team team) {
        if (!StringUtils.isEmpty(team.getName())) {
            teamService.create(team.getName(), team.getCity(), team.getStadium());
            return ResponseEntity.ok(team);
        } else {
            return new ResponseEntity("Empty team name", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value= "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Team team) {
        if (!StringUtils.isEmpty(team.getName())) {
            teamService.update(team);
            return ResponseEntity.ok(team);
        } else {
            return new ResponseEntity("Empty data", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (readOneTeam(id).getStatusCode().value() == 200) {
            teamService.delete(id);
            return new ResponseEntity("Team deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Team not found", HttpStatus.NOT_FOUND);
        }
    }
}
