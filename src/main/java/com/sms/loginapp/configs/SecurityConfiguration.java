package com.sms.loginapp.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/addView").hasAnyRole("ADMIN")
                .requestMatchers("/listView").hasAnyRole("EDITOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return httpSecurity.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()
                .withUser("adailton").password("$2a$10$fvTdqqb2MeRnzjQH765Vr.N.KXfyYmAyjbEXLe.0iGAX6os4qU6OO").roles("EDITOR", "ADMIN")
                .and()
                .withUser("usuario").password("$2a$10$fvTdqqb2MeRnzjQH765Vr.N.KXfyYmAyjbEXLe.0iGAX6os4qU6OO").roles("EDITOR");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
