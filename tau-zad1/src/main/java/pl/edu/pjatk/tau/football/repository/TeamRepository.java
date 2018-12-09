package pl.edu.pjatk.tau.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.tau.football.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
