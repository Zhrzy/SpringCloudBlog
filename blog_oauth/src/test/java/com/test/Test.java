package com.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zy 1716457206@qq.com
 */
public class Test {


    @org.junit.Test
    public void test1(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String ss = passwordEncoder.encode("secret");
        System.out.println(ss);
    }
}
