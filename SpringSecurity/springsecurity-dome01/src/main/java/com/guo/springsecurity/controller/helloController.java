package com.guo.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/11/10:02
 */
@RestController
@RequestMapping("helloController")
public class helloController {


    @RequestMapping("security")
    public String hello(){
        return "hello security";
    }

    @RequestMapping("/login")
    public String login(){
        return "登录";
    }

    @RequestMapping("/toError")
    public String toError(){
        return "登录失败";
    }

    @RequestMapping("/toMain")
//    // 根据角色判断 访问  "/toMain" 这个接口时需要有 "ROLE_admin" 角色 否则访问不了
//    // 访问不了时 前台会报500  日志显示 不允许访问
//    // 必须以"ROLE_" 开头 + 角色
//    @Secured("ROLE_admin") // 自测显示的是403

    // @PreAuthorize("hasRole('admin')")   在访问资源之前就行判断控制
    @PreAuthorize("hasRole('abc')") // 有admin角色的用户才可以访问资源
    public String toMain(){
        return "toMain";
    }
}
