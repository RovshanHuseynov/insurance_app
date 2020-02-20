package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.User;
import rovshan.insurance_app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        if(user != null) {
            return userService.createUser(user);
        }
        else{
            throw new IllegalArgumentException("Input cannot be null");
        }
    }

    @GetMapping("login/{username},{password}")
    public User login(@PathVariable("username") String username_, @PathVariable("password") String password_){
        if(username_ == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        else if(password_ == null){
            throw new IllegalArgumentException("Password cannot be null");
        }
        else{
            return userService.login(username_, password_);
        }
    }

    @GetMapping("get/{companyId}")
    public User getUserByCompanyId(@PathVariable("userId") long userId_){
        return userService.getUserByCompanyId(userId_);
    }

    @PutMapping("edit/{userId}")
    public User editUser(@RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("delete/{userId}")
    public User deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }
}