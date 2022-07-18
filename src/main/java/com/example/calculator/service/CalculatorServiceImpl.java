package com.example.calculator.service;

import com.example.calculator.dto.OperationType;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public Integer binaryOperation(Integer firstOperator, OperationType operationType, Integer secondOperator) {
        return operationType.getOperator().apply(firstOperator, secondOperator);
    }
}
