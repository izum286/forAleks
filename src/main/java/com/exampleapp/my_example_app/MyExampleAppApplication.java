package com.exampleapp.my_example_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MyExampleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyExampleAppApplication.class, args);
    }
}
