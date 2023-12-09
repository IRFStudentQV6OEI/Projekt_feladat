package uni.covinus.Projekt_feladat.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.covinus.Projekt_feladat.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
