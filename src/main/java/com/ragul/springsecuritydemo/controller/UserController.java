package com.ragul.springsecuritydemo.controller;

import com.ragul.springsecuritydemo.entity.User;
import com.ragul.springsecuritydemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public String getAllUsers() {
        return userService.getAllUsers().toString();
    }

    @GetMapping("/id/{id}")
    public String getUserById(@PathVariable Integer id) {
        return userService.getUserById(id).toString();
    }

    @GetMapping("/{username}")
    public String getUserByUserName(@PathVariable String username) {
        return userService.getUserByUserName(username).toString();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

}
