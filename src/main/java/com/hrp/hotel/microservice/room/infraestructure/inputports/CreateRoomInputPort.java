package com.hrp.hotel.microservice.room.infraestructure.inputports;

import com.hrp.hotel.microservice.common.exceptions.EntityAlreadyExistsException;
import com.hrp.hotel.microservice.room.application.createroomusecase.CreateRoomRequest;
import jakarta.persistence.EntityNotFoundException;

public interface CreateRoomInputPort {
    void createRoom(Long idHotel, CreateRoomRequest createRoomRequest) throws EntityNotFoundException, EntityAlreadyExistsException;
}
