package com.mehdisarf.StartSpringImplMehdiSarf.controllers.advice;

import com.mehdisarf.StartSpringImplMehdiSarf.exceptions.NotEnoughMoneyException;
import com.mehdisarf.StartSpringImplMehdiSarf.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    // send information about the exception that occurred, from the controller’s action to the
    // advice by adding a parameter to the advice’s exception handler method of the type of the handled exception.
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(NotEnoughMoneyException exception) {
        // Spring is smart enough to pass the exception reference from the controller
        // to the advice’s exception handler method. You can then use any details of the
        // exception instance in the advice’s logic

        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setMessage(exception.getLocalizedMessage() + " " + exception.getClass().getName() + " Not enough money to make the payment.");

        return ResponseEntity.badRequest().body(errorDetails);
    }
}
