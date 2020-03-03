package rovshan.insurance_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rovshan.insurance_app.entity.Employer;
import rovshan.insurance_app.service.UserService;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Employer createUser(@Valid @RequestBody Employer employer){
        return userService.createUser(employer);
    }

    @GetMapping("login/{username},{password}")
    public Employer login(@Valid @PathVariable("username") String username_, @Valid @PathVariable("password") String password_){
        return userService.login(username_, password_);
    }

    @GetMapping("get/{userId}")
    public Employer get(@Valid @PathVariable("userId") Long userId_){
        return userService.get(userId_);
    }

    @PutMapping("edit")
    public Employer editUser(@Valid @RequestBody Employer employer){
        return userService.editUser(employer);
    }

    @DeleteMapping("delete/{userId}")
    public Employer deleteUser(@Valid @PathVariable("userId") Long userId_){
        return userService.deleteUser(userId_);
    }
}