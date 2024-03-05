package com.hg.security.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 17:12
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {



        // 创建返回结果
        Map<String, String> result = Map.of("code", "200", "msg", "注销成功");

        // 将结果转换为json对象
        String json = JSON.toJSONString(result);

        // 返回结果到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
