package com.epam.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder().sources(ConfigurationApplication.class).run(args);
    }
}
