package com.hg.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 16:08
 */
//@SpringBootTest
public class PassWordTest {

    @Test
    void testEncoder() {
        // 工作因子，默认值为10，可以设置为4-31，值越大运算速度越慢

        System.out.println("start");
        BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder(17);
        long start = System.currentTimeMillis();
        encoder1.encode("123456");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("================");

        BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder(4);
        start = System.currentTimeMillis();
        encoder2.encode("123456");
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
