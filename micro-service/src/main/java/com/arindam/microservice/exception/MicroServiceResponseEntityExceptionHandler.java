package com.arindam.microservice.exception;

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
public class MicroServiceResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest) {
        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(new Date(),
                        exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleAllUserNotFoundExceptions(UserNotFoundException exception, WebRequest webRequest) {
        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(new Date(),
                        exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
