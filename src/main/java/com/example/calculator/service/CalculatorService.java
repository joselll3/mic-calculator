package com.example.calculator.service;

import com.example.calculator.util.OperationType;

public interface CalculatorService {

    Long binaryOperation(Long firstOperator, OperationType operationType, Long secondOperator);
}
