package com.hg.security.controller;

import com.hg.security.pojo.entity.User;
import com.hg.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 15:09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.list();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.saveUserDetails(user);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public String test() {
        return "TTTTTTT";
    }
}
