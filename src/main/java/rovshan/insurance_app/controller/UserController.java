package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.User;
import rovshan.insurance_app.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("login/{username},{password}")
    public User login(@Valid @PathVariable("username") String username_, @Valid @PathVariable("password") String password_){
        return userService.login(username_, password_);
    }

    @GetMapping("get/{companyId}")
    public List<User> getUsersByCompanyId(@Valid @PathVariable("companyId") Long companyId_){
        return userService.getUsersByCompanyId(companyId_);
    }

    @PutMapping("edit")
    public User editUser(@Valid @RequestBody User user){
        return userService.editUser(user);
    }

    @DeleteMapping("delete/{userId}")
    public User deleteUser(@Valid @PathVariable("userId") Long userId_){
        return userService.deleteUser(userId_);
    }
}