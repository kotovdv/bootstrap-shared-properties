package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Component
    public static class Printer {

        private final String libXProducedProperty;
        private final String libYProducedProperty;

        public Printer(@Value("${libX.produced.property}") String libXProducedProperty,
                       @Value("${libY.produced.property}") String libYProducedProperty) {
            this.libXProducedProperty = libXProducedProperty;
            this.libYProducedProperty = libYProducedProperty;
        }

        @PostConstruct
        public void init() {
            System.out.println("X = " + libXProducedProperty);
            System.out.println("Y = " + libYProducedProperty);
        }
    }

}
