package com.college.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages="com.college.*")
@SpringBootApplication
@EnableEurekaClient
public class TeacherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
