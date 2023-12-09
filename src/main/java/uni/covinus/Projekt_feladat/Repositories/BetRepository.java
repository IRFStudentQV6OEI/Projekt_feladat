package uni.covinus.Projekt_feladat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.covinus.Projekt_feladat.Entities.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUserId(Long userId);
}
