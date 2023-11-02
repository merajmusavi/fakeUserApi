package com.example.demo.api;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Validated @RequestBody @NonNull User user) {
        userService.addUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path = "{id}")
    public User getUser(@PathVariable("id") UUID id){
        return userService.getUserById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public  void deleteUserById(@PathVariable("id") UUID uuid){
        userService.deleteUser(uuid);
    }
    @PutMapping(path = "{id}")
    public void updateUserById(@PathVariable("id") UUID uuid,@RequestBody User user){
        userService.updateUser(uuid,user);
    }
}
