package com.loan.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanNotValidException extends RuntimeException{

    public LoanNotValidException(String message) {
        super(message);
    }
}
