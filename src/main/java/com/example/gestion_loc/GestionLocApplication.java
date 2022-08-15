package com.example.gestion_loc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("entities")
@SpringBootApplication
public class GestionLocApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLocApplication.class, args);
    }

}
