package com.hrp.hotel.microservice.room.infraestructure.outputadapters.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoomEntityRepository extends JpaRepository<RoomEntity, Integer> {
    Optional<RoomEntity> findByName(String name);
    Optional<RoomEntity> findByNameAndHotel(String name, Long hotelId);
    @Query("SELECT r.pricePerNight FROM RoomEntity r WHERE r.name = :name AND r.hotel = :hotelId")
    Double findRoomPriceByNameAndHotelId(@Param("name") String name, @Param("hotelId") Long hotelId);
}
