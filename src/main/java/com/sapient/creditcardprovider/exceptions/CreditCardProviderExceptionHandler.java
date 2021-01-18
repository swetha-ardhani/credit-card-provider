package com.sapient.creditcardprovider.exceptions;

import com.sapient.creditcardprovider.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CreditCardProviderExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String exMessage = "Status " + HttpStatus.BAD_REQUEST + " - Invalid field : " + ex.getBindingResult().getFieldError().getField();
        ErrorMessage error = new ErrorMessage();
        error.setHttpCode(HttpStatus.BAD_REQUEST.toString().substring(0, 3));
        error.setHttpMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        error.setMessage(exMessage);
        return error;
    }
}
