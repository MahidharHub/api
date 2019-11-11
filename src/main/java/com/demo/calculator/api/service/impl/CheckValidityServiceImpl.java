package com.demo.calculator.api.service.impl;

import com.demo.calculator.api.exception.NumberNotDivisibleException;
import com.demo.calculator.api.exception.NumberNotValidException;
import com.demo.calculator.api.service.CheckValidityService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CheckValidityServiceImpl implements CheckValidityService {

    private final static Logger LOG = Logger.getLogger(CheckValidityServiceImpl.class.getName());

    /**
     *  Method for validating the second number equivalent to zero or not
     * @param number
     */
    @Override
    public void checkNotDivisibleByZero(final Optional<String> number) {
        LOG.info("validating NotDivisible by zero condition");
        if(!(number.isPresent()  && !(number.get().isEmpty())  && NumberUtils.isDigits(number.get()) && !(NumberUtils.createInteger(number.get()) == 0))){
        throw new NumberNotDivisibleException("The number cannot be divided by zero.Please provide a non zero number") ;
        }
    }

    /**
     * Method for validating whether the given numbers are valid or not.
     * Used in the calculator API
     * @param number1
     * @param number2
     */
    @Override
    public void checkNumbersValidity(final Optional<String> number1, final Optional<String> number2) {
        LOG.info("validating numbers vavlidity for calculator API operations");
        if(!(number1.isPresent() && number2.isPresent() && !(number1.get().isEmpty()) && NumberUtils.isDigits(number1.get()) && !(number2.get().isEmpty()) && NumberUtils.isDigits(number2.get()) )){
            throw new  NumberNotValidException("Not valid numbers.Please verify the numbers annd give correct numbers");
        }
    }

    /**
     * Method for validating whether the given number is valid or not.
     *  Used in the Scientific calculator API
     * @param number
     */
    @Override
    public void checkNumberValidity(final Optional<String> number) {
        LOG.info("validating number vavlidity for scientific API operations");
        if(!(number.isPresent()  && !(number.get().isEmpty()) && NumberUtils.isDigits(number.get())  )){
            throw new  NumberNotValidException("Not a valid number.Please verify the number annd give correct number");
        }

    }
}
