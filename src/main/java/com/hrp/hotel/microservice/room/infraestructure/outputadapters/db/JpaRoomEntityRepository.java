package com.hrp.hotel.microservice.room.infraestructure.outputadapters.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoomEntityRepository extends JpaRepository<RoomEntity, Integer> {
    Optional<RoomEntity> findByName(String name);
    Optional<RoomEntity> findByNameAndHotel(String name, Long hotelId);
}
