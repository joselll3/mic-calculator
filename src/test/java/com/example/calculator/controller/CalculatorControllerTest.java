package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import com.example.calculator.util.OperationType;
import io.corp.calculator.TracerAPI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    private static final Long OPERATOR_FIRST = 99L;
    private static final Long OPERATOR_LAST = 22L;

    private static final Long RESULT_ADD = 121L;

    private static final String URL_TEST_ADD = String.format("/binary-operation/%d/%s/%d", OPERATOR_FIRST, OperationType.ADD, OPERATOR_LAST);

    private static final String URL_TEST_SUBTRACT = String.format("/binary-operation/%d/%s/%d", OPERATOR_FIRST, OperationType.SUBTRACT, OPERATOR_LAST);

    @MockBean
    private TracerAPI tracerAPI;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void when_call_binaryOperation_expect_validJson() throws Exception {
        when(calculatorService.binaryOperation(OPERATOR_FIRST,OperationType.ADD, OPERATOR_LAST ))
                .thenReturn(RESULT_ADD);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_TEST_ADD))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.value").value(RESULT_ADD));

    }

    @Test
    void when_call_binaryOperationSubtract_expect_callCalculatorService() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_TEST_SUBTRACT))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(calculatorService).binaryOperation(OPERATOR_FIRST, OperationType.SUBTRACT, OPERATOR_LAST);
    }

    @Test
    void when_call_binaryOperationAdd_expect_callCalculatorService() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_TEST_ADD))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(calculatorService).binaryOperation(OPERATOR_FIRST, OperationType.ADD, OPERATOR_LAST);
    }

    @Test
    void when_call_binaryOperation_expect_callTracerApi() throws Exception {

        when(calculatorService.binaryOperation(OPERATOR_FIRST,OperationType.ADD, OPERATOR_LAST )).thenReturn(RESULT_ADD);

        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URL_TEST_ADD))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(tracerAPI).trace(Mockito.anyString());
    }

    @Test
    void when_call_invalidArguments_expect_BadRequest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/binary-operation/A/B/C"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}