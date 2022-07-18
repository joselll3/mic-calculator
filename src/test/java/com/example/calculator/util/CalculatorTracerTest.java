package com.example.calculator.util;

import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorTracerTest {

    private final static String TRACE_MESSAGE = "trace message";
    @Mock
    private TracerImpl tracerImpl;

    @InjectMocks
    private CalculatorTracer calculatorTracer;

    @Test
    void expect_call_trace(){
        calculatorTracer.trace(TRACE_MESSAGE);

        verify(tracerImpl).trace(TRACE_MESSAGE);
    }
}