package com.yang.secyritydome01.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**springsecurity-dome01
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/10/22:22
 */

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // 用户名
        String userName = "gy";
        // 加密密码为"123"，并返回
        String rawPassword = new BCryptPasswordEncoder().encode("123");
        // 权限：权限是个List集合，且不能为空
        List<GrantedAuthority> authList = AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        // 返回一个User对象
        return new User(userName,rawPassword,authList);
    }
}
