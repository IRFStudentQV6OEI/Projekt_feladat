package uni.covinus.Projekt_feladat.Service;

import uni.covinus.Projekt_feladat.Entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
}
