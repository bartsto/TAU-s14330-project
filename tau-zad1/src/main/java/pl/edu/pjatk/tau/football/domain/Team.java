package pl.edu.pjatk.tau.football.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String stadium;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
    private LocalDateTime lastReadTime;

    public Team() {
    }

    public Team(String name, String city, String stadium) {
        this.name = name;
        this.city = city;
        this.stadium = stadium;
    }

    public Team(int id, String name, String city, String stadium, LocalDateTime creationTime, LocalDateTime lastUpdateTime, LocalDateTime lastReadTime) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.stadium = stadium;
        this.creationTime = creationTime;
        this.lastUpdateTime = lastUpdateTime;
        this.lastReadTime = lastReadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public LocalDateTime getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(LocalDateTime lastReadTime) {
        this.lastReadTime = lastReadTime;
    }
}
