package com.hrp.hotel.microservice.room.application.getpriceusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.room.infraestructure.inputports.GetPriceInputPort;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;
import jakarta.persistence.EntityNotFoundException;

@UseCase
public class GetPriceUseCase implements GetPriceInputPort {
    private final RoomPersistencePort roomPersistencePort;

    public GetPriceUseCase(RoomPersistencePort roomPersistencePort) {
        this.roomPersistencePort = roomPersistencePort;
    }

    @Override
    public Double getPrice(String roomName, Long hotelId) throws EntityNotFoundException {
        if(roomPersistencePort.findByNameAndIdHotel(roomName, hotelId).isEmpty()) {
            throw new EntityNotFoundException("the room not exist");
        }
        return roomPersistencePort.getRoomPrice(roomName, hotelId);
    }
}
