package com.hrp.hotel.microservice.hotel.infrastructure.inputports;

import com.hrp.hotel.microservice.hotel.domain.Hotel;

import java.util.Optional;

public interface FindHotelInputPort {
    Optional<Hotel> findHotel(Long hotelId);
}
