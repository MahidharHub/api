package com.demo.calculator.api.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

public interface CalculatorService {

    BigInteger addition(Optional<String> number1, Optional<String> number2);

    BigInteger substraction(Optional<String> number1, Optional<String> number2);

    BigInteger multiplication(Optional<String> number1, Optional<String> number2);

    BigInteger division(Optional<String> number1, Optional<String> number2);

}
