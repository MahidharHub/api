package com.demo.calculator.api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * This controller provides the response pages whenever there is error in the application.
 * The default WhiteLable page has been disabled
 */
@Controller
public class CalculatorErrorController implements ErrorController {

    /**
     * This method handles the error and propogates to the correct html page
     * @param request
     * @return
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500";
            }
        }
        return "error";
    }

    /**
     * This method gets the error path
     * @return
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
