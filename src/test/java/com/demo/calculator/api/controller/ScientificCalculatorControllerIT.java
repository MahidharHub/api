package com.demo.calculator.api.controller;

import com.demo.calculator.api.ApiApplication;
import com.demo.calculator.api.exception.ExceptionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScientificCalculatorControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @BeforeEach
    public void before() {

        headers.setAccept(Arrays.asList(MediaType.ALL));
    }

    @Test
    public void calculatorSquareTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/scientific/square/20"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("400"));
    }


    @Test
    public void calculatorFactorialTest() throws Exception {

        ResponseEntity<BigInteger> response = restTemplate.getForEntity(createPort("/scientific/factorial/5"),
                BigInteger.class);
        assertTrue(response.getBody().toString().equals("120"));
    }


    @Test
    public void calculatorPrimeTest() throws Exception {

        ResponseEntity<Boolean> response = restTemplate.getForEntity(createPort("/scientific/prime/23"),
                Boolean.class);
        assertTrue(response.getBody().toString().equals("true"));
    }


    @Test
    public void calculatorSquareNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/scientific/square/sd"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not a valid number.Please verify the number annd give correct number"));
    }


    @Test
    public void calculatorFactorialNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse>   response = restTemplate.getForEntity(createPort("/scientific/factorial/5d"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not a valid number.Please verify the number annd give correct number"));
    }


    @Test
    public void calculatorPrimeNotNumberTest() throws Exception {

        ResponseEntity<ExceptionResponse> response = restTemplate.getForEntity(createPort("/scientific/prime/23D"),
                ExceptionResponse.class);
        assertTrue( response.getStatusCode().is4xxClientError());
        assertTrue(response.getBody().getMessage().equals("Not a valid number.Please verify the number annd give correct number"));
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
