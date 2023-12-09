package uni.covinus.Projekt_feladat.Service;

import uni.covinus.Projekt_feladat.Entities.Match;

import java.util.List;

public interface MatchService {
    Match saveMatch(Match match);
    void deleteMatch(Long matchId);
    Match getMatchById(Long matchId);
    List<Match> getAllMatches();
    void updateMatchesFromExternalSource();
}
