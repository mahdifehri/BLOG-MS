package com.example.blogms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BlogMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogMsApplication.class, args);
	}

}
