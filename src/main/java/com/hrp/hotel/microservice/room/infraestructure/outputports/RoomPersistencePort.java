package com.hrp.hotel.microservice.room.infraestructure.outputports;

import com.hrp.hotel.microservice.room.domain.Room;

import java.util.Optional;

public interface RoomPersistencePort {
    void saveRoom(Room room);

    Optional<Room> findRoomByName(String name);

    Optional<Room> findByNameAndIdHotel(String name, Long hotelId);

    double getRoomPrice(String name, Long hotelId);

    boolean updateRoomAvailable(Room room);
}
