package com.demo.calculator.api.exception;

import com.google.common.collect.Lists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 *  This class is a Global Exception Handler .Here all the probable exceptions thrown by API are handled
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * This method handles NumberNotValidException
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(NumberNotValidException.class)
    public final ResponseEntity<Object> handleNumberNotValidExceptions(NumberNotValidException ex, WebRequest request) {

        ExceptionResponse exceptionResponse  =
                new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false) + "  not valid request");

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles NumberNotDivisibleException
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(NumberNotDivisibleException.class)
    public final ResponseEntity<Object> handleNotDivisibleExcecptions(NumberNotDivisibleException ex, WebRequest request) {

        ExceptionResponse exceptionResponse  =
                new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false) + "  not valid request");

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles MethodArgumentNotValidException
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        ExceptionResponse exceptionResponse  =
                new ExceptionResponse(new Date(),"Validations failed",ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles all other remaining or Non handled exceptions
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse  =
                new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
