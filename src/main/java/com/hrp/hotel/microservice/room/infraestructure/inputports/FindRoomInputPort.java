package com.hrp.hotel.microservice.room.infraestructure.inputports;

import com.hrp.hotel.microservice.room.domain.Room;

import java.util.Optional;

public interface FindRoomInputPort {
    Optional<Room> findByNameAndHotel(String roomName, Long hotelId);
}
