package com.example.calculator.dto;

import java.util.function.BinaryOperator;

public enum OperationType {
    ADD ((a, b)-> a + b),
    SUBTRACT ((a, b) -> a-b);

    private BinaryOperator<Integer> operator;
    OperationType(BinaryOperator<Integer> operator){
        this.operator = operator;
    }

    public BinaryOperator<Integer> getOperator(){
        return this.operator;
    }


}
