package com.example.calculator.service;

import com.example.calculator.dto.OperationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CalculatorServiceImplTest {

    private static final Integer OPERATOR_FIRST = 40;
    private static final Integer OPERATOR_LAST = 3;

    private static final Integer OPERATOR_ADD_RESULT = 43;

    private static final Integer OPERATOR_SUBTRACT_RESULT = 37;

    private CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void when_add_expect_addOperators(){
        Integer result = calculatorService.binaryOperation(OPERATOR_FIRST, OperationType.ADD, OPERATOR_LAST);

        assertEquals(OPERATOR_ADD_RESULT, result);
    }

    @Test
    void when_subtract_expect_subtractOperators(){
        Integer result = calculatorService.binaryOperation(OPERATOR_FIRST, OperationType.SUBTRACT, OPERATOR_LAST);

        assertEquals(OPERATOR_SUBTRACT_RESULT, result);
    }
}