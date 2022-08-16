package com.gjalic.springdgjalic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDGjalicApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringDGjalicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDGjalicApplication.class, args);
    }

}
