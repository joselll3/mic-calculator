package com.example.calculator.service;

import com.example.calculator.util.OperationType;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public Long binaryOperation(Long firstOperator, OperationType operationType, Long secondOperator) {
        return operationType.getOperator().apply(firstOperator, secondOperator);
    }
}
