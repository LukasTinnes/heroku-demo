package com.example.demo.controller;

import com.example.demo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    private final CustomerRepository customerRepository;

    public HelloController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        String users = String.valueOf(customerRepository.findAll());
        return ResponseEntity.ok(users);
    }

}
