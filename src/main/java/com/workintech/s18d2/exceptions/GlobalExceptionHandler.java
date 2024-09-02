package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException(VegetableException vegetableException){
        VegetableErrorResponse response = new VegetableErrorResponse(vegetableException.getMessage());
        log.error("Exception occurred: ", vegetableException);
        return new ResponseEntity<>(response, vegetableException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException fruitException){
        FruitErrorResponse response = new FruitErrorResponse(fruitException.getMessage());
        log.error("Exception occurred: ", fruitException);
        return new ResponseEntity<>(response, fruitException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        PlantErrorResponse response = new PlantErrorResponse(exception.getMessage());
        log.error("Exception occurred: ", exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
