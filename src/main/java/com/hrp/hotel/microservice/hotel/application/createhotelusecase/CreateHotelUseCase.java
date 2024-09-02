package com.hrp.hotel.microservice.hotel.application.createhotelusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.CreateHotelInputPort;
import com.hrp.hotel.microservice.hotel.infrastructure.outputports.db.HotelPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@UseCase
@Transactional
public class CreateHotelUseCase implements CreateHotelInputPort {
    private final HotelPersistencePort hotelPersistencePort;

    public CreateHotelUseCase( HotelPersistencePort hotelPersistencePort) {
        this.hotelPersistencePort = hotelPersistencePort;
    }

    public Hotel useCase(CreateHotelRequest createHotelRequest) {
        Hotel hotel = createHotelRequest.toHotel();
        hotelPersistencePort.saveHotel(hotel);
        return hotel;
    }

    @Override
    public Hotel createHotel(CreateHotelRequest createHotelRequest) throws Exception {
        return useCase(createHotelRequest);
    }

    @Override
    public Hotel findHotelById(Long id) throws EntityNotFoundException {
        return null;
    }
}
