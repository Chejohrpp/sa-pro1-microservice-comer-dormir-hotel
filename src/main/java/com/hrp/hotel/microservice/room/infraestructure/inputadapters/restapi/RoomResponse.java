package com.hrp.hotel.microservice.room.infraestructure.inputadapters.restapi;

import lombok.Value;

@Value
public class RoomResponse {
    String message;

    public static RoomResponse from(String message) {
        return new RoomResponse(message);
    }
}
