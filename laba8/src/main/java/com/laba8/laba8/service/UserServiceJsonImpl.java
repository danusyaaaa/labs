package com.laba8.laba8.service;

import com.google.gson.Gson;
import com.laba8.laba8.model.User;
import com.laba8.laba8.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;

@Service
@RequiredArgsConstructor
public class UserServiceJsonImpl implements UserService {

    private final UserRepo userRepo;
    public final Gson gson;

    @Value("${file.json}")
    private String fileString;

    @SneakyThrows
    @Override
    public User getUserById(int id) {
        User user = gson.fromJson(new FileReader(fileString), User.class);
        if (user.getId() == id) {
            return user;
        }
        return null;
    }

    @SneakyThrows
    @Override
    public User saveUser() {
        User user = gson.fromJson(new FileReader(fileString), User.class);
        return userRepo.save(user);
    }

    @SneakyThrows
    @Override
    public User deleteUser() {
        User user = gson.fromJson(new FileReader(fileString), User.class);
        userRepo.delete(user);
        return user;
    }

    @SneakyThrows
    @Override
    public User updateUser(User userUpdate) {
        User user = gson.fromJson(new FileReader(fileString), User.class);
        if (user.getId() == userUpdate.getId()) {
            user = userUpdate;
        } else {
            return null;
        }
        return userRepo.save(user);
    }
}
