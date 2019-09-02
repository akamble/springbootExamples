package com.sbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DApplication {
    public static void main(String[] args) {
       ConfigurableApplicationContext context=  SpringApplication.run(DApplication.class);

        System.out.println(context.getEnvironment().getSystemEnvironment());

    }
}
