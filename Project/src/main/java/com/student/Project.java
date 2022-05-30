package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.student" })
public class Project {

	public static void main(String[] args) {
		SpringApplication.run(Project.class, args);
	}

}
