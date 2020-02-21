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
        Optional<User> userOp = Optional.ofNullable(user);
        return userRepository.save(userOp.orElseThrow(() -> new Exception("CREATE USER operation could not be executed. user could not found")));
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() ->
                new Exception(String.format("login operation could not be executed. %s and %s could not be found", username, password)));
    }

    public User getUserByCompanyId(Long userId_) {
        return null;
    }

    public User editUser(User user) {
        Optional<User> userOp = Optional.ofNullable(userRepository.save(user));
        return userRepository.save(userOp.orElseThrow(() -> new Exception("EDIT USE operation could not be executed. user could not found")));
    }

    public User deleteUser(Long userId) {
        Optional<User> userOp = userRepository.findById(userId);
        if(userOp.isPresent()){
            userRepository.delete(userOp.get());
            return userOp.get();
        }
        else{
            throw new Exception(String.format("User with %s id could not found", userId));
        }
    }
}