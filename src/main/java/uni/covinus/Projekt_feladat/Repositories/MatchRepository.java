package uni.covinus.Projekt_feladat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.covinus.Projekt_feladat.Entities.Match;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
