package com.test.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// handle entire web exception, this is spring MVC way
// by default, spring handlerExceptionResolver able to handle 3 type
//  1. ExceptionHandlerExceptionResolver - @ExceptionHandler
//  2. ResponseStatusExceptionResolver - @ResponseStatus
//  3. DefaultHandlerExceptionResolver
// for browser client it will return whitelabel page, for machine client will return JSON error
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithmeticException(){
        return ""; // we can return ModelAndView here example login
    }
}

