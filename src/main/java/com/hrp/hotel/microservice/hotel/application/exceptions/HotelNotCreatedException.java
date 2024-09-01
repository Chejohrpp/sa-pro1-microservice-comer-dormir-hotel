package com.hrp.hotel.microservice.hotel.application.exceptions;

public class HotelNotCreatedException extends RuntimeException {
    public HotelNotCreatedException(String message) {
        super(message);
    }
}
