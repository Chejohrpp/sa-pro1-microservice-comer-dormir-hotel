package com.hrp.hotel.microservice.room.infraestructure.inputports;

import jakarta.persistence.EntityNotFoundException;

public interface UpdateAvailableInputPort {
    boolean updateAvailable(Long hotelId, String roomNumber, Boolean available ) throws EntityNotFoundException;
}
