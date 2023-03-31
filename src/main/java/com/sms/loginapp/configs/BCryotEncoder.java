package com.sms.loginapp.configs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryotEncoder {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }

}
