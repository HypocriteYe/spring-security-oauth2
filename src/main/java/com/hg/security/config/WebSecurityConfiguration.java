package com.hg.security.config;

import com.hg.security.component.DBUserDetailsManager;
import com.hg.security.handler.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/5 14:28
 */
@Configuration
@EnableMethodSecurity
//@EnableWebSecurity
public class WebSecurityConfiguration {

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        // 基于内存的用户信息管理器
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 创建userDetails对象用于管理用户名、密码、权限、角色信息
//        manager.createUser(User.withDefaultPasswordEncoder().username("hg").password("123456").roles("USER").build());
//        return manager;
//    }

//    @Bean
//    public UserDetailsService  userDetailsService() {
//
//        // 基于数据库的用户信息管理器
//        return new DBUserDetailsManager();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 认证授权配置
        http.authorizeHttpRequests(authenticate -> {
//            authenticate.requestMatchers("/user/list").hasAuthority("USER_LIST");
//            authenticate.requestMatchers("/user/add").hasAuthority("USER_ADD");
//            authenticate.requestMatchers("/user/**").hasRole("ADMIN");
            authenticate.anyRequest().authenticated();
//            authenticate.requestMatchers("/logout").permitAll();
        });

        // 登录配置
        http.formLogin(form -> {
            // 无需授权
            form.loginPage("/login").permitAll();
            form.usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(new MyAuthenticationSuccessHandler())
                    .failureHandler(new MyAuthenticationFailHandler())
            ;
                    // 校验失败的跳转地址
//                    .failureUrl("/login?error");
        });

        // 登出配置
        http.logout(logout -> {
            logout.logoutSuccessHandler(new MyLogoutSuccessHandler());
        });

        // 错误处理
        http.exceptionHandling(exception -> {
            // 请求未认证
            exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());
            // 没有权限
            exception.accessDeniedHandler(new MyAccessDeniedHandler());
        });

        // 禁用跨站请求伪造
        http.csrf(AbstractHttpConfigurer::disable);

        // 跨域请求访问
        http.cors(Customizer.withDefaults());

        // 自定义session过期策略
        http.sessionManagement(session -> {
           session.maximumSessions(1).expiredSessionStrategy(new MySessionInformationExpiredStrategy());
        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
