package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean authenticate(User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser != null && Objects.equals(foundUser.getPassword(), user.getPassword())) {
            log.info("Logged user: {}", foundUser.getEmail());
            return true;
        } else {
            log.info("User not found or password incorrect!");
            return false;
        }
    }
}
