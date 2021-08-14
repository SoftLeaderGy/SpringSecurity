package com.guo.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/11/11:13
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // form表单
        http.formLogin()
                // 自定义登录页面
                .loginPage("/login.html")
                // 点击登录，去执行自定义登录逻辑（去找UserServiceImpl里边写的登录逻辑）
                .loginProcessingUrl("/login")
                // 登录成功跳转页面,或是Controller  必须是post请求方式
                .successForwardUrl("/helloController/login")
                // 登录失败的请求
                .failureForwardUrl("/helloController/toError")

                // 自定义登录页面form表单参数名称
                .usernameParameter("username123")
                .passwordParameter("password123");


        // 授权
        http.authorizeRequests()
                //放行登录页面
                .antMatchers("/login.html").permitAll()
                //放行登录失败请求
                .antMatchers("/helloController/toError").permitAll()
                /**
                 * 只有什么样的权限下可以放行，
                 */
//                // .antMatchers("/main.html")表示放行资源  ， .hasAuthority("admin")  表示有什么样的权限下可以放行
//                // .hasAuthority("admin")可以匹配一个权限,
//                .antMatchers("/main.html").hasAuthority("admin")
//                // 可以匹配多个权限
//                .antMatchers("/main.html").hasAnyAuthority("admin,ad,admin1")

//                /**
//                 * 只有什么样的ip地址下可以放行
//                 */
//                .antMatchers("/main.html").hasIpAddress("127.0.0.1")


                /**
                 * 有什么样的角色才能放行
                 */
                // 登录用户必须有 abc 角色才可以访问资源 角色的配置是  在 UserServiceImpl里边是 ROLE_"角色"
                // 但是在SecurityConfig配置中不需要加上ROLE_ 因为源码里 已经给我们自拼上了
                .antMatchers("/main.html").hasRole("adc")
                // 所有请求都要授权
                .anyRequest().authenticated();

        // 关闭防火墙
        http.csrf().disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
