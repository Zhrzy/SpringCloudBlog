package com.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author  小章鱼 1716457206@qq.com
 */
public class Test {
    @org.junit.Test
    public void test1(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String ss = passwordEncoder.encode("666666");
        System.out.println(ss);
    }
}
