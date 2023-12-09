package uni.covinus.Projekt_feladat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uni.covinus.Projekt_feladat.Entities.Match;
import uni.covinus.Projekt_feladat.Repositories.MatchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final RestTemplate restTemplate; // Külső API hívásokhoz
    @Value("${theoddsapi.apikey}")
    private String apikey;
    private final String apiUrl = "https://api.the-odds-api.com/v4/sports/{sport}/odds/?apiKey={apikey}&regions={region}";

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository, RestTemplate restTemplate) {
        this.matchRepository = matchRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public Match getMatchById(Long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        return match.orElseThrow(() -> new RuntimeException("Match not found with id: " + matchId));
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public void updateMatchesFromExternalSource() {
        // Külső API hívás és adatok feldolgozása
        // Például: List<Match> matches = restTemplate.getForObject(apiUrl, List<Match>.class);
        // matchRepository.saveAll(matches);
    }
}
