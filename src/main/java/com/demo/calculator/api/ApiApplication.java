package com.demo.calculator.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  Calculator API
 *  provides two REST API's
 *  1.Calculator API
 *  2.Scientific Calculator API
 */
@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
