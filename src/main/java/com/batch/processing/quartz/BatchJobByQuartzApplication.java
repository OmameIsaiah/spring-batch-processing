package com.batch.processing.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.batch.processing.quartz"})
public class BatchJobByQuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchJobByQuartzApplication.class, args);
    }
}