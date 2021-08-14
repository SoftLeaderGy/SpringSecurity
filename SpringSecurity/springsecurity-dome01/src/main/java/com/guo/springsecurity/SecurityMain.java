package com.guo.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/11/09:58
 */
@SpringBootApplication
// 开启注解实现角色控制
// securedEnabled = true --> @Secured  实现角色控制
// prePostEnabled = true -->
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityMain {
    public static void main(String[] args) {
        SpringApplication.run(SecurityMain.class,args);
    }
}
