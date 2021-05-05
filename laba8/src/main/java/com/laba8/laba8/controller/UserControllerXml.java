package com.laba8.laba8.controller;

import com.laba8.laba8.model.User;
import com.laba8.laba8.service.UserServiceXmlImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("xml/user")
@RequiredArgsConstructor
public class UserControllerXml {

    private final UserServiceXmlImpl userService;

    @GetMapping("{id}")
    public User showUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/save")
    public User saveUser() {
        return userService.saveUser();
    }

    @GetMapping("/delete")
    public User deleteUser() {
        return userService.deleteUser();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

}
