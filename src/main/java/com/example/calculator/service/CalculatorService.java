package com.example.calculator.service;

import com.example.calculator.dto.OperationType;

public interface CalculatorService {

    Integer binaryOperation(Integer firstOperator, OperationType operationType, Integer secondOperator);
}
