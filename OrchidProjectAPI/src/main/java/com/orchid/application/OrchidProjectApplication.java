package com.orchid.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.orchid")
@Configuration
@SpringBootApplication
public class OrchidProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OrchidProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OrchidProjectApplication.class);
	}
}
