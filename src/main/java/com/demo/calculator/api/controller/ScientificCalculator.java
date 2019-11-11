package com.demo.calculator.api.controller;

import com.demo.calculator.api.service.impl.ScientificCalculatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

/**
 *   This scientific calculatotr controller has 3 REST API get methods for the calcualtion of Square Numbers,
 *   Factorial of a given number and determining whether the given number is Prime or not
 *   All the methods return the BigInteger value except the /prime URI. It returns the boolean value
 */
@RestController
@RequestMapping("/scientific")
public class ScientificCalculator {

  @Autowired
  ScientificCalculatorServiceImpl scientificCalculatorService;

    /**
     * Calcualtes the square number of the given number
     * @param number
     * @return
     */
    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET )
    public ResponseEntity<BigInteger> square(@PathVariable("number") Optional<String> number) {

        return  ResponseEntity.ok(scientificCalculatorService.square(number));
    }

    /**
     * calcualtes the factorial number of the give number
     * @param number
     * @return
     */

    @RequestMapping(value = "/factorial/{number}", method = RequestMethod.GET )
    public ResponseEntity<BigInteger> factorial(@PathVariable("number") Optional<String> number) {
        return  ResponseEntity.ok(scientificCalculatorService.factorial(number));
    }

    /**
     * Determines whether the given number is Prime or not
     * @param number
     * @return
     */

    @RequestMapping(value = "/prime/{number}", method = RequestMethod.GET )
    public ResponseEntity<Boolean> primeNumber(@PathVariable("number") Optional<String> number) {
        return  ResponseEntity.ok(scientificCalculatorService.isPrime(number));
    }
}
