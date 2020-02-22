package com.college.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@RefreshScope
@ComponentScan(basePackages="com.college.*")
@SpringBootApplication
@EnableEurekaClient
public class StudentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProducerApplication.class, args);
	}

}
