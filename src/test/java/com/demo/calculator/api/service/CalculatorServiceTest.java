package com.demo.calculator.api.service;

import com.demo.calculator.api.exception.NumberNotDivisibleException;
import com.demo.calculator.api.exception.NumberNotValidException;
import com.demo.calculator.api.service.impl.CalculatorServiceImpl;
import com.demo.calculator.api.service.impl.CheckValidityServiceImpl;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @Mock
    CheckValidityServiceImpl checkValidityService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void additionTest() throws Exception{

        Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("10"),Optional.of("20"));
        BigInteger value = calculatorService.addition(Optional.of("10"),Optional.of("20"));
        assertEquals(NumberUtils.createBigInteger("30"), value);
    }


    @Test
    public void substractionTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("60"),Optional.of("20"));
        BigInteger value = calculatorService.substraction(Optional.of("60"),Optional.of("20"));
        assertEquals(NumberUtils.createBigInteger("40"), value);
    }


    @Test
    public void multiplicationTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("30"),Optional.of("20"));
        BigInteger value = calculatorService.multiplication(Optional.of("30"),Optional.of("20"));
        assertEquals(NumberUtils.createBigInteger("600"), value);
    }


    @Test
    public void divisionTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("100"),Optional.of("20"));
        BigInteger value = calculatorService.division(Optional.of("100"),Optional.of("20"));
        assertEquals(NumberUtils.createBigInteger("5"), value);
    }

    @Test
    public void additionWithNonNumberTest() throws Exception{

        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("sd"),Optional.of("20"));
            BigInteger value = calculatorService.addition(Optional.of("sd"),Optional.of("20"));
        });
    }

    @Test
    public void substractionWithNonNumberTest() throws Exception{

        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("aa"),Optional.of("20"));
            BigInteger value = calculatorService.substraction(Optional.of("aa"),Optional.of("20"));
        });
    }


    @Test
    public void multiplicationWithNonNumberTest() throws Exception{

        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("ss"),Optional.of("20"));
            BigInteger value = calculatorService.multiplication(Optional.of("ss"),Optional.of("20"));
        });
    }


    @Test
    public void divisionWithNonNumberTest() throws Exception{

        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumbersValidity(Optional.of("ss"),Optional.of("20"));
            BigInteger value = calculatorService.division(Optional.of("ss"),Optional.of("20"));
        });
    }


    @Test
    public void divisionWithZeroTest() throws Exception{

        assertThrows(NumberNotDivisibleException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNotDivisibleByZero(Optional.of("0"));
            BigInteger value = calculatorService.division(Optional.of("100"),Optional.of("0"));
        });
    }
}
