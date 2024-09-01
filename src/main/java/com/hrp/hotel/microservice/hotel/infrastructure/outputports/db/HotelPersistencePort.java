package com.hrp.hotel.microservice.hotel.infrastructure.outputports.db;

import com.hrp.hotel.microservice.hotel.domain.Hotel;

public interface HotelPersistencePort {
    void saveHotel(Hotel hotel);
}
