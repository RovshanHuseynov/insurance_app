package rovshan.insurance_app.service;

import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.User;
import rovshan.insurance_app.repository.UserRepository;

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
        return userRepository.findByUsernameAndPassword(username, password).get();
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