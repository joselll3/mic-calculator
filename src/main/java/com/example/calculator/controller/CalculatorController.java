package com.example.calculator.controller;

import io.corp.calculator.TracerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/hello")
    String hello(){
        return "Hello";
    }
}
