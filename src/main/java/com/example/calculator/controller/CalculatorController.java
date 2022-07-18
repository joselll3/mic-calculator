package com.example.calculator.controller;

import io.corp.calculator.TracerAPI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController {

    private final TracerAPI tracerAPI;

    @GetMapping("/hello")
    String hello(){
        tracerAPI.trace("hello");
        return "Hello";
    }
}
