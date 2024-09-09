package com.example.demo.runner;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GenerateUser implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = List.of(
                new User(UUID.randomUUID().toString(), "test@gmail.com", "test"),
                new User(UUID.randomUUID().toString(), "test@test.ru", "test")
        );

        for (User user : users) {
            try {
                userService.addUser(user);
                System.out.println("Пользователь добавлен: " + user.getEmail());
            } catch (Exception e) {
                System.out.println("Не удалось добавить пользователя: " + user.getEmail() + ". Причина: " + e.getMessage());
            }
        }
    }
}