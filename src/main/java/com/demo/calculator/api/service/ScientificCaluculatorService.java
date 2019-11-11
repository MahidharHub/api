package com.demo.calculator.api.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public interface ScientificCaluculatorService {

    BigInteger square(Optional<String> number);

    BigInteger factorial(Optional<String> number);

    boolean isPrime(Optional<String> number);

}
