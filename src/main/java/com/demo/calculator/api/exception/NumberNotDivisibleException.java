package com.demo.calculator.api.exception;


public class NumberNotDivisibleException extends  RuntimeException {

    public   NumberNotDivisibleException(String message){
        super(message);
    }
}
