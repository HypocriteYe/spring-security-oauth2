package com.hg.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hg.security.pojo.entity.User;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 15:07
 */
public interface UserService extends IService<User> {
    void saveUserDetails(User user);
}
