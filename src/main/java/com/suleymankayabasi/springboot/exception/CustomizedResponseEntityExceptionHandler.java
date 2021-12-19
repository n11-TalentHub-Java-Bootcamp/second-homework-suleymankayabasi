package com.suleymankayabasi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        Date errorDate = new Date();
        String message = ex.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse =  new ExceptionResponse
                (errorDate,message,description);

       return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions
            (ProductNotFoundException productNotFoundException, WebRequest webRequest){

        Date errorDate = new Date();
        String message = productNotFoundException.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse =  new ExceptionResponse
                (errorDate,message,description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions
            (UserNotFoundException userNotFoundException, WebRequest webRequest){

        Date errorDate = new Date();
        String message = userNotFoundException.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse =  new ExceptionResponse
                (errorDate,message,description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions
            (ProductReviewNotFoundException productReviewNotFoundException, WebRequest webRequest){

        Date errorDate = new Date();
        String message = productReviewNotFoundException.getMessage();
        String description = webRequest.getDescription(false);

        ExceptionResponse exceptionResponse =  new ExceptionResponse
                (errorDate,message,description);

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
