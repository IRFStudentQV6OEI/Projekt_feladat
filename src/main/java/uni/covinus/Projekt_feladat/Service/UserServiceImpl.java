package uni.covinus.Projekt_feladat.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import uni.covinus.Projekt_feladat.Entities.User;
import uni.covinus.Projekt_feladat.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        // Itt hozzáadható további logika, pl. jelszó titkosítása
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        validateUser(user);
        // Ellenőrizd, hogy a felhasználó létezik-e az adatbázisban
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException("Felhasználó nem található a következő azonosítóval: " + userId));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    private void validateUser(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (!StringUtils.hasText(user.getUsername())) throw new IllegalArgumentException("Kérem adjon meg felhasználónevet");
        if (!StringUtils.hasText(user.getPassword())) throw new IllegalArgumentException("Kérem adjon meg Jelszót");

    }
}