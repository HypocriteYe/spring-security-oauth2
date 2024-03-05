package com.hg.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hg.security.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 15:05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
