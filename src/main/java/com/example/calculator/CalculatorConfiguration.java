package com.example.calculator;

import com.example.calculator.util.CalculatorTracer;
import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {

    @Bean
    public TracerImpl tracerImpl(){
        return new TracerImpl();
    }

    @Bean
    public CalculatorTracer calculatorTracer(TracerImpl tracerImpl){
        return new CalculatorTracer(tracerImpl);
    }
}
