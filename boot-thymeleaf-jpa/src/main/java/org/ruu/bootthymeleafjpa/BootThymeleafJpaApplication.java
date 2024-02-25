package org.ruu.bootthymeleafjpa;

import org.hibernate.annotations.Filter;
import org.ruu.bootthymeleafjpa.controller.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootThymeleafJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootThymeleafJpaApplication.class, args);
    }

}
