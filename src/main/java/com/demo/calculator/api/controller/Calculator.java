package com.demo.calculator.api.controller;

import com.demo.calculator.api.service.impl.CalculatorServiceImpl;
import com.demo.calculator.api.service.impl.CheckValidityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

/**
 *  This calculator controller has 4 REST API get methods for the Addition, Substraction,Multiplication and Division of
 *  the given numbers. All the methods return the BigInteger values
 */
@RestController
@RequestMapping("/calculator")
public class Calculator {

    @Autowired
    CalculatorServiceImpl calculatorService;
    @Autowired
    CheckValidityServiceImpl checkValidityService;

    /**
     * Calculates the addition value of given two numbers
     * @param number1
     * @param number2
     * @return
     */
    @RequestMapping(value = "/addition/{number1}/{number2}", method = RequestMethod.GET )
    public ResponseEntity<Object> addition(@PathVariable("number1") Optional<String> number1, @PathVariable("number2")  Optional<String> number2) {

           return ResponseEntity.ok(calculatorService.addition(number1, number2));
    }

    /**
     * Calculates the substraction value of given two numbers
     * @param number1
     * @param number2
     * @return
     */
    @RequestMapping(value = "/substraction/{number1}/{number2}", method = RequestMethod.GET )
    public ResponseEntity<BigInteger> substraction(@PathVariable("number1")  Optional<String> number1,@PathVariable("number2")  Optional<String> number2) {
        return  ResponseEntity.ok(calculatorService.substraction(number1,number2));
    }

    /**
     * Calculates the multiplication value of given two numbers
     * @param number1
     * @param number2
     * @return
     */
    @RequestMapping(value = "/multiplication/{number1}/{number2}", method = RequestMethod.GET )
    public ResponseEntity<BigInteger> multiplication(@PathVariable("number1")  Optional<String> number1,@PathVariable("number2")  Optional<String> number2) {
        return  ResponseEntity.ok(calculatorService.multiplication(number1,number2));
    }

    /**
     * Calculates the division value of given two numbers
     * @param number1
     * @param number2
     * @return
     */
    @RequestMapping(value = "/division/{number1}/{number2}", method = RequestMethod.GET )
    public ResponseEntity<BigInteger> division(@PathVariable("number1")  Optional<String> number1,@PathVariable("number2")  Optional<String> number2) {
        return  ResponseEntity.ok(calculatorService.division(number1,number2));
    }
}
