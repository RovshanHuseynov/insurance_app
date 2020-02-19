package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
        return userService.createUser(user);
    }

    @GetMapping("login/{userId}")
    public User login(@PathVariable("userId") long userId_){
        return userService.login(userId_);
    }

    @GetMapping("get/{userId}")
    public User getUserById(@PathVariable("userId") long userId_){
        return userService.getUserById(userId_);
    }
}
