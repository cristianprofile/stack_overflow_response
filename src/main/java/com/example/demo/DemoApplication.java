package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {



    @Autowired
    AuthorRepository  authorRepository;


    @Autowired
    BookRepository  bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
