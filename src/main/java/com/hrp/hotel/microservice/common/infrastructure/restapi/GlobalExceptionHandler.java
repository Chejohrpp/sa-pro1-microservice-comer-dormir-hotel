package com.hrp.hotel.microservice.common.infrastructure.restapi;

import com.hrp.hotel.microservice.hotel.application.exceptions.HotelNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNotCreatedException.class)
    public ResponseEntity<String> handleHotelNotCreatedException(HotelNotCreatedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
