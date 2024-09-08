package com.hrp.hotel.microservice.hotel.application.gethotel;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.FindHotelInputPort;
import com.hrp.hotel.microservice.hotel.infrastructure.outputports.db.HotelPersistencePort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UseCase
@Transactional
public class GetHotelUseCase implements FindHotelInputPort {
    private final HotelPersistencePort hotelPersistencePort;

    @Autowired
    public GetHotelUseCase(HotelPersistencePort hotelPersistencePort) {
        this.hotelPersistencePort = hotelPersistencePort;
    }

    @Override
    public Optional<Hotel> findHotel(Long hotelId) {
        return hotelPersistencePort.findHotelById(hotelId);
    }
}
