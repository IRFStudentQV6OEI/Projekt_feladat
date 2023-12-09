package uni.covinus.Projekt_feladat.Service;

import uni.covinus.Projekt_feladat.Entities.Bet;

import java.util.List;

public interface BetService {
    Bet placeBet(Bet bet);
    void deleteBet(Long betId);
    Bet getBetById(Long betId);
    List<Bet> getAllBets();
    List<Bet> getBetsByUserId(Long userId);
}
