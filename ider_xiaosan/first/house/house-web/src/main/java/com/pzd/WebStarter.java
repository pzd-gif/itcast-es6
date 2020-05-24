package com.pzd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WebStarter {
    public static void main(String[] args) {
        SpringApplication.run(WebStarter.class,args);
    }
}
