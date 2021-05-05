package com.laba8.laba8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class Laba8Application {
	public static void main(String[] args) {
		SpringApplication.run(Laba8Application.class, args);
	}
}
