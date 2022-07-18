package com.example.calculator.controller;

import com.example.calculator.dto.OperationResultDto;
import com.example.calculator.dto.OperationType;
import com.example.calculator.service.CalculatorService;
import io.corp.calculator.TracerAPI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController {

    private final TracerAPI tracerApi;

    private final CalculatorService calculatorService;

    @GetMapping("/binary-operation/{firstOperand}/{operationType}/{secondOperand}")
    ResponseEntity<OperationResultDto> binaryOperation(@Validated @PathVariable Integer firstOperand,
                                                       @Validated @PathVariable OperationType operationType,
                                                       @Validated @PathVariable Integer secondOperand){
        Integer value = calculatorService.binaryOperation(firstOperand, operationType, secondOperand);
        OperationResultDto operationResult = new OperationResultDto(firstOperand, operationType, secondOperand, value);
        tracerApi.trace(operationResult);
        return ResponseEntity.ok(operationResult);
    }


}
