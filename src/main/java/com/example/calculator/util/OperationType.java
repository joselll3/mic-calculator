package com.example.calculator.util;

import java.util.function.BinaryOperator;

public enum OperationType {
    ADD ((a, b)-> a + b),
    SUBTRACT ((a, b) -> a-b);

    private BinaryOperator<Long> operator;
    OperationType(BinaryOperator<Long> operator){
        this.operator = operator;
    }

    public BinaryOperator<Long> getOperator(){
        return this.operator;
    }


}
