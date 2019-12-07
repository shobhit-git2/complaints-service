package com.ibm.complaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ComplaintServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintServiceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
						.allowedOrigins("http://localhost:4200") // ur Angular server url
						.allowedHeaders("Authorization", "Content-Type", "Cache-Control"); // Add the headers whichever
																							// you wants allow
			}
		};
	}

}
