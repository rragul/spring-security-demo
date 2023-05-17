package com.ragul.springsecuritydemo.service;

import com.ragul.springsecuritydemo.entity.User;
import com.ragul.springsecuritydemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String updateUser(Integer id,User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setRoles(user.getRoles());
        userRepository.save(existingUser);
        return "User updated successfully";
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }


}
