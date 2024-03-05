package com.hg.security.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;
import java.util.Map;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 17:53
 */
public class MySessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {

        SessionInformation information = event.getSessionInformation();

        // 创建返回结果
        Map<String, String> result = Map.of("code", "-1", "msg", "该账号已从其他设备登录", "data", JSON.toJSONString(information));

        // 将结果转换为json对象
        String json = JSON.toJSONString(result);

        // 返回结果到前端
        event.getResponse().setContentType("application/json;charset=UTF-8");
        event.getResponse().getWriter().println(json);
    }
}
