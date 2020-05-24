package com.pzd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.pzd.mapper")
public class CourseJifenService8003 {

	public static void main(String[] args) {
		SpringApplication.run(CourseJifenService8003.class, args);
	}
}
