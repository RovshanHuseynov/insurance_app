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

    public User getUserByCompanyId(long userId_) {
        if(login(userId_).getRole().toString().equals("SUPERADMIN")){

        }
        else if(login(userId_).getRole().toString().equals("ADMIN")){

        }
        else if(login(userId_).getRole().toString().equals("OPERATOR")){

        }
        return null;
    }

    public User login(long userId_) {
        if(userRepository.existsById(userId_)){
            return userRepository.findById(userId_).get();
        }
        return null;
    }

    public User editUser(User user) {
        return userRepository.save(user);
    }
}
