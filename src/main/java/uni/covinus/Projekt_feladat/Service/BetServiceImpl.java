package uni.covinus.Projekt_feladat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.covinus.Projekt_feladat.Entities.Bet;
import uni.covinus.Projekt_feladat.Repositories.BetRepository;
import uni.covinus.Projekt_feladat.Repositories.MatchRepository;
import uni.covinus.Projekt_feladat.Repositories.UserRepository;
import uni.covinus.Projekt_feladat.Service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class BetServiceImpl implements BetService {

    private final BetRepository betRepository;
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public BetServiceImpl(BetRepository betRepository, UserRepository userRepository, MatchRepository matchRepository) {
        this.betRepository = betRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Bet placeBet(Bet bet) {
        validateBet(bet);
        // További logika, pl. a fogadás érvényességének ellenőrzése
        return betRepository.save(bet);
    }

    @Override
    public void deleteBet(Long betId) {
        betRepository.deleteById(betId);
    }

    @Override
    public Bet getBetById(Long betId) {
        Optional<Bet> bet = betRepository.findById(betId);
        return bet.orElseThrow(() -> new RuntimeException("Bet not found with id: " + betId));
    }

    @Override
    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    @Override
    public List<Bet> getBetsByUserId(Long userId) {
        return betRepository.findByUserId(userId);
    }

    private void validateBet(Bet bet) {
        if (bet == null) {
            throw new IllegalArgumentException("Bet cannot be null");
        }
        if (bet.getAmount() == null || bet.getAmount().signum() <= 0) {
            throw new IllegalArgumentException("Invalid bet amount");
        }
        if (!userRepository.existsById(bet.getUser().getId())) {
            throw new IllegalArgumentException("User does not exist");
        }
        if (!matchRepository.existsById(bet.getMatch().getId())) {
            throw new IllegalArgumentException("Match does not exist");
        }
    }
}
