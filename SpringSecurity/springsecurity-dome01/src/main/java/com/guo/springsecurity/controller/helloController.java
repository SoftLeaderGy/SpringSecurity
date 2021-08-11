package com.guo.springsecurity.controller;

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
}
