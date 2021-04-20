package com.test.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason = "Too many users")
public class UserExceedException  extends RuntimeException{

    public UserExceedException() {
    }

    public UserExceedException(String message){
        super(message);
    }
}
