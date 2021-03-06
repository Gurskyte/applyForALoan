package com.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(
        basePackageClasses = { Application.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}
