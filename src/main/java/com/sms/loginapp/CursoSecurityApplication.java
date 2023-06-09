package com.sms.loginapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CursoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSecurityApplication.class, args);
	}

}
