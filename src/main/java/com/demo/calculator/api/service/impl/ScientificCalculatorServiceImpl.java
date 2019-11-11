package com.demo.calculator.api.service.impl;

import com.demo.calculator.api.service.ScientificCaluculatorService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ScientificCalculatorServiceImpl implements ScientificCaluculatorService {

    private final static Logger LOG = Logger.getLogger(ScientificCalculatorServiceImpl.class.getName());

    @Autowired
    CheckValidityServiceImpl checkValidityService;

    /**
     * Square operation
     * @param number
     * @return
     */
    @Override
    public BigInteger square(final Optional<String> number) {
        LOG.info("performing square operation");
        checkValidityService.checkNumberValidity(number);
        return NumberUtils.createBigInteger(number.get()).multiply(NumberUtils.createBigInteger(number.get()));
    }

    /**
     * Factorial operation
     * @param number
     * @return
     */
    @Override
    public BigInteger factorial(final Optional<String> number) {
        LOG.info("performing factorial operation");
        checkValidityService.checkNumberValidity(number);
        return calculateFactorial(Integer.parseInt(number.get()));
    }

    /**
     *  Isprime operation
     * @param number
     * @return
     */
    @Override
    public boolean isPrime(final Optional<String> number) {
        LOG.info("performing isPrime operation");
        checkValidityService.checkNumberValidity(number);
        return  NumberUtils.createBigInteger(number.get()).isProbablePrime(Integer.parseInt(number.get()));
    }


    public BigInteger calculateFactorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }



}
