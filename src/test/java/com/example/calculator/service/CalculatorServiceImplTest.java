package com.example.calculator.service;

import com.example.calculator.util.OperationType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class CalculatorServiceImplTest {

    private static final Long OPERATOR_FIRST = 40L;
    private static final Long OPERATOR_LAST = 3L;

    private static final Long OPERATOR_ADD_RESULT = 43L;

    private static final Long OPERATOR_SUBTRACT_RESULT = 37L;

    private CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    @Test
    void when_add_expect_addOperators(){
        Long result = calculatorService.binaryOperation(OPERATOR_FIRST, OperationType.ADD, OPERATOR_LAST);

        assertEquals(OPERATOR_ADD_RESULT, result);
    }

    @Test
    void when_subtract_expect_subtractOperators(){
        Long result = calculatorService.binaryOperation(OPERATOR_FIRST, OperationType.SUBTRACT, OPERATOR_LAST);

        assertEquals(OPERATOR_SUBTRACT_RESULT, result);
    }
}