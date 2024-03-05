package com.hg.security.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 16:52
 */
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String message = exception.getLocalizedMessage();

        // 创建返回结果
        Map<String, String> result = Map.of("code", "-1", "msg", "登录失败", "data", message);

        // 将结果转换为json对象
        String json = JSON.toJSONString(result);

        // 返回结果到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
