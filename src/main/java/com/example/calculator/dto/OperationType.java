package com.example.calculator.dto;

import java.util.function.BiFunction;

public enum OperationType {
    ADD ((a, b)-> a + b),
    SUBTRACT ((a, b) -> a-b);

    private BiFunction<Integer, Integer, Integer> biFunction;
    OperationType(BiFunction<Integer, Integer, Integer> biFunction){
        this.biFunction = biFunction;
    }

    public BiFunction<Integer, Integer, Integer> getBiFunction(){
        return this.biFunction;
    }


}
