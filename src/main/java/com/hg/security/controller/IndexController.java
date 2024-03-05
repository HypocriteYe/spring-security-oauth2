package com.hg.security.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 14:02
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(JSON.toJSONString(authentication));
        return "index";
    }

}
