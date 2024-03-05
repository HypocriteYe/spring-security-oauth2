package com.hg.security.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 18:16
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        String message = accessDeniedException.getLocalizedMessage();

        // 创建返回结果
        Map<String, String> result = Map.of("code", "-1", "message", message);

        // 将结果转换为json对象
        String json = JSON.toJSONString(result);

        // 返回结果到前端
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
