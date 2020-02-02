package com.springboot.springbootjparest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringbootJpaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRestApplication.class, args);
	}
}
