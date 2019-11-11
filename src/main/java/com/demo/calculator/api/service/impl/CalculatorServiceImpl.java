package com.demo.calculator.api.service.impl;

import com.demo.calculator.api.service.CalculatorService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final static Logger LOG = Logger.getLogger(CalculatorServiceImpl.class.getName());

    @Autowired
    CheckValidityServiceImpl checkValidityService;

    /**
     *  Addition operation
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public BigInteger addition(final Optional<String> number1, final Optional<String> number2) {
        LOG.info("performing addition operation");
        checkValidityService.checkNumbersValidity(number1,number2);
        return NumberUtils.createBigInteger(number1.get()).add(NumberUtils.createBigInteger(number2.get()));
    }

    /**
     * Substraction operation
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public BigInteger substraction(final Optional<String> number1, final Optional<String> number2) {
        LOG.info("performing substraction operation");
        checkValidityService.checkNumbersValidity(number1,number2);
        return NumberUtils.createBigInteger(number1.get()).subtract(NumberUtils.createBigInteger(number2.get()));
    }

    /**
     *  Multiplication operation
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public BigInteger multiplication(final Optional<String> number1, final Optional<String> number2) {
        LOG.info("performing multiplication operation");
        checkValidityService.checkNumbersValidity(number1,number2);
        return NumberUtils.createBigInteger(number1.get()).multiply(NumberUtils.createBigInteger(number2.get()));
    }

    /**
     * Division operation
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public BigInteger division(final Optional<String> number1, final Optional<String> number2) {
        LOG.info("performing division operation");
        checkValidityService.checkNumbersValidity(number1,number2);
        checkValidityService.checkNotDivisibleByZero(number2);
        return NumberUtils.createBigInteger(number1.get()).divide(NumberUtils.createBigInteger(number2.get()));
    }
}
