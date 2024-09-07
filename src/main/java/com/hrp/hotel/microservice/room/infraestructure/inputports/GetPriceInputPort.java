package com.hrp.hotel.microservice.room.infraestructure.inputports;

import jakarta.persistence.EntityNotFoundException;

public interface GetPriceInputPort {
    Double getPrice(String roomName, Long hotelId) throws EntityNotFoundException;
}
