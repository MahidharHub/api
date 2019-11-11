package com.demo.calculator.api.controller;

import com.demo.calculator.api.ApiApplication;
import com.demo.calculator.api.exception.ExceptionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @BeforeEach
    public void before() {

        headers.setAccept(Arrays.asList(MediaType.ALL));
    }

    @Test
    public void calculatorAdditionTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/calculator/addition/10/20"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("30"));
    }


    @Test
    public void calculatorDivisionTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/calculator/division/200/25"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("8"));
    }


    @Test
    public void calculatorSubstractionTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/calculator/substraction/100/20"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("80"));
    }


    @Test
    public void calculatorMultiplyTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/calculator/multiplication/10/20"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("200"));
    }


    @Test
    public void calculatorAdditionNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/calculator/addition/10/ee"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not valid numbers.Please verify the numbers annd give correct numbers"));
    }


    @Test
    public void calculatorSubstractionNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/calculator/substraction/10/ee"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not valid numbers.Please verify the numbers annd give correct numbers"));
    }

    @Test
    public void calculatorMultiplicationNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/calculator/multiplication/q11a/100"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not valid numbers.Please verify the numbers annd give correct numbers"));
    }

    @Test
    public void calculatorDivisionNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/calculator/division/dd/ee"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not valid numbers.Please verify the numbers annd give correct numbers"));
    }

    @Test
    public void calculatorDivisionWithZeroFailTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/calculator/division/100/0"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("The number cannot be divided by zero.Please provide a non zero number"));
    }

    /**
     * This method creates the dynamic port
     * @param uri
     * @return dynamic port appended to http://localhost
     */

    private String createPort(final String uri) {
        return "http://localhost:" + port + uri;
    }

}
