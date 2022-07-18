package com.example.calculator.dto;

import lombok.Data;

@Data
public class OperationResultDto {

    private final Integer firstOperand;
    private final OperationType operationType;
    private final Integer secondOperand;
    private final Integer value;
}
