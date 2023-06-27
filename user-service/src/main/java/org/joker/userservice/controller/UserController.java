package org.joker.userservice.controller;

import org.joker.userservice.mapper.UserMapper;
import org.joker.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        User user = userMapper.selectUserById(userId);
        return user;
    }
}
