package com.hrp.hotel.microservice.room.application.findroomusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.infraestructure.inputports.FindRoomInputPort;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;

import java.util.Optional;

@UseCase
public class FindRoomUseCase implements FindRoomInputPort {

    private final RoomPersistencePort roomPersistencePort;

    public FindRoomUseCase(RoomPersistencePort roomPersistencePort) {
        this.roomPersistencePort = roomPersistencePort;
    }

    @Override
    public Optional<Room> findByNameAndHotel(String roomName, Long hotelId) {
        return roomPersistencePort.findByNameAndIdHotel(roomName, hotelId);
    }
}
