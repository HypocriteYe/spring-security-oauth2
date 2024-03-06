package com.hg.security.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 09:29
 */
@Controller
public class OAuth2Controller {

    @GetMapping("/oauth2")
    public String oauth2(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                         @AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println(JSON.toJSONString(authorizedClient));
        System.out.println(JSON.toJSONString(oAuth2User));
        model.addAttribute("userName", oAuth2User.getName());
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
        return "oauth2";
    }
}
