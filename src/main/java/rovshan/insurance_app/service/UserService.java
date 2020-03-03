package rovshan.insurance_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rovshan.insurance_app.entity.Employer;
import rovshan.insurance_app.exception.Exception;
import rovshan.insurance_app.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Employer createUser(Employer employer) {
        Optional<Employer> userOP = Optional.ofNullable(employer);
        return userRepository.save(userOP.orElseThrow(() -> new Exception("CREATE USER operation could not be executed. User could not found")));
    }

    public Employer login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(() ->
                new Exception(String.format("LOGIN operation could not be executed. %s and %s could not be found", username, password)));
    }

    public Employer get(Long userId_) {
        return userRepository.findById(userId_).orElseThrow(() ->
                new Exception(String.format("GET operation could not be executed. %d could not be found", userId_)));
    }

    public List<Employer> getUsersByCompanyId(Long companyId_) {
        return userRepository.findUsersByCompanyId(companyId_);
    }

    public Employer editUser(Employer employer) {
        Optional<Employer> userOP = Optional.ofNullable(userRepository.save(employer));
        return userRepository.save(userOP.orElseThrow(() -> new Exception("EDIT USER operation could not be executed. user could not found")));
    }

    public Employer deleteUser(Long userId) {
        Optional<Employer> userOP = userRepository.findById(userId);
        if(userOP.isPresent()){
            userRepository.delete(userOP.get());
            return userOP.get();
        }
        else{
            throw new Exception(String.format("DELETE USER operation could not be executed. User with %s id could not found", userId));
        }
    }
}