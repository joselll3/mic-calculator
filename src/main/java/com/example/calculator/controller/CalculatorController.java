package com.example.calculator.controller;

import com.example.calculator.openapi.api.BinaryOperationApi;
import com.example.calculator.openapi.model.OperationResultDto;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.util.OperationType;
import io.corp.calculator.TracerAPI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController implements BinaryOperationApi {

    private final TracerAPI tracerApi;

    private final CalculatorService calculatorService;

    @Override
    public ResponseEntity<OperationResultDto> binaryOperation(Long firstOperand,
                                                       String operationType,
                                                       Long secondOperand){
        Long value = calculatorService.binaryOperation(firstOperand, OperationType.valueOf(operationType), secondOperand);
        tracerApi.trace(String.format("%d %s %d = %d", firstOperand, operationType, secondOperand, value));
        return ResponseEntity.ok(new OperationResultDto().value(value));
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<Object>  handleException() {
        return ResponseEntity.badRequest().build();
    }
}
