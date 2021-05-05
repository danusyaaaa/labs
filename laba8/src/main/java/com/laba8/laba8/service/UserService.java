package com.laba8.laba8.service;

import com.laba8.laba8.model.User;

public interface UserService {

    User getUserById(int id);

    User saveUser();

    User deleteUser();

    User updateUser(User user);
}
