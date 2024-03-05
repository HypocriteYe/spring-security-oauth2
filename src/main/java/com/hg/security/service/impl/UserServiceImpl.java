package com.hg.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hg.security.component.DBUserDetailsManager;
import com.hg.security.mapper.UserMapper;
import com.hg.security.pojo.entity.User;
import com.hg.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 15:07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private DBUserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUserDetails(User user) {
        userDetailsManager.createUser(org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .passwordEncoder(passwordEncoder::encode)
                .build());
    }
}
