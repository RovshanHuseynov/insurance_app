package rovshan.insurance_app.service;

import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.User;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() ->
                new Exception(String.format("login operation could not be executed. %s and %s could not be found", username, password)));
    }

    public User getUserByCompanyId(Long userId_) {
        return null;
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return null;
    }
}