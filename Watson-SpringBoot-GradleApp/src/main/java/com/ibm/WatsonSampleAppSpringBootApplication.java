package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class WatsonSampleAppSpringBootApplication extends SpringBootServletInitializer{
	

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WatsonSampleAppSpringBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WatsonSampleAppSpringBootApplication.class, args);
	}
}
