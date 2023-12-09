package uni.covinus.Projekt_feladat.Entities;

import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    private BigDecimal amount;

    private String winner; // Csapat neve, amelyre a felhasználó fogad

    // Standard getters and setters
}
