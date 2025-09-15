package ru.serkov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HadoopIntegrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(HadoopIntegrationApplication.class, args);
    }
}