package com.hrp.hotel.microservice.hotel.infrastructure.outputports.db;

import com.hrp.hotel.microservice.hotel.domain.Hotel;

import java.util.Optional;

public interface HotelPersistencePort {
    void saveHotel(Hotel hotel);

    Optional<Hotel> findHotelById(Long id);
}
