package com.guo.springsecurity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/11/11:15
 */
@Service
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder pw;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("执行自定义登录逻辑");
        // 1.根据username查询数据库密码

        if(!"admin".equals(username)){
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        // 2、根据查询的对象比较密码

        String password = pw.encode("123456");
        // 3、返回用户对象

        log.info("paw : "+password);
        return new User("admin",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
