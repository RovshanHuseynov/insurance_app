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
