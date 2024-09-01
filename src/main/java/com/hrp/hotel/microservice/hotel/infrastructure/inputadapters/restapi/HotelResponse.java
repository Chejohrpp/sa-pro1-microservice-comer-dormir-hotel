package com.hrp.hotel.microservice.hotel.infrastructure.inputadapters.restapi;

import lombok.Value;

@Value
public class HotelResponse {
    String message;

    public static HotelResponse from(String message) {
        return new HotelResponse(message);
    }
}
