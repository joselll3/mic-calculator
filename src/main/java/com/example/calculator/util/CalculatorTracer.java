package com.example.calculator.util;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

@RequiredArgsConstructor
public class CalculatorTracer implements TracerAPI {
    private final TracerImpl tracerImpl;

    @Override
    public <T> void trace(T t) {
        tracerImpl.trace(t);
    }
}
