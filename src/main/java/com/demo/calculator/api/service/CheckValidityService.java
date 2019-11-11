package com.demo.calculator.api.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public interface CheckValidityService {

    void checkNumbersValidity(Optional<String> number1, Optional<String> number2);
    void checkNumberValidity(Optional<String> number);
    void checkNotDivisibleByZero(Optional<String> number);

}
