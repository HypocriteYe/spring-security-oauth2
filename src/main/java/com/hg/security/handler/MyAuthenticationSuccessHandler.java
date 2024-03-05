package com.hg.security.handler;

import com.alibaba.fastjson2.JSON;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 16:52
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String principal = authentication.getPrincipal().toString();


        // 创建返回结果
        Map<String, String> result = Map.of("code", "200", "msg", "登录成功", "data", principal);

        // 将结果转换为json对象
        String json = JSON.toJSONString(result);

        // 返回结果到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
