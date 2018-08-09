package com.consulting.core.cra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.consulting.core.cra.model", entityManagerFactoryRef="entityManagerFactory")
public class CraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CraApplication.class, args);
	}
}
