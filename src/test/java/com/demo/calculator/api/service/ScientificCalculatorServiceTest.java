package com.demo.calculator.api.service;

import com.demo.calculator.api.exception.NumberNotValidException;
import com.demo.calculator.api.service.impl.CheckValidityServiceImpl;
import com.demo.calculator.api.service.impl.ScientificCalculatorServiceImpl;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ScientificCalculatorServiceTest {

    @InjectMocks
    ScientificCalculatorServiceImpl scientificCalculatorService;

    @Mock
    CheckValidityServiceImpl checkValidityService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void squareTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("10"));
        BigInteger value = scientificCalculatorService.square(Optional.of("10"));
        assertEquals(NumberUtils.createBigInteger("100"), value);
    }


    @Test
    public void factorialTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("5"));
        BigInteger value = scientificCalculatorService.factorial(Optional.of("5"));
        assertEquals(NumberUtils.createBigInteger("120"), value);
    }


    @Test
    public void primeTest() throws Exception{
        Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("7"));
        boolean value = scientificCalculatorService.isPrime(Optional.of("7"));
        assertEquals(true, value);
    }


    @Test
    public void squareNonNumberTest() throws Exception{
        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("ss"));
            BigInteger value = scientificCalculatorService.square(Optional.of("ss"));
        });
    }


    @Test
    public void factorialNonNumberTest() throws Exception{
        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("ss"));
            BigInteger value = scientificCalculatorService.factorial(Optional.of("ss"));
        });
    }


    @Test
    public void primeNonNumberTest() throws Exception{
        assertThrows(NumberNotValidException.class,()-> {
            Mockito.doCallRealMethod().when(checkValidityService).checkNumberValidity(Optional.of("ss"));
            boolean value = scientificCalculatorService.isPrime(Optional.of("ss"));
        });
    }
}
