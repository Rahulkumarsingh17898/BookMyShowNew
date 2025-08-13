package com.rkstech.bookyourshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing// for timestamp generation we need to enable it
public class BookyourshowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookyourshowApplication.class, args);
    }

}
