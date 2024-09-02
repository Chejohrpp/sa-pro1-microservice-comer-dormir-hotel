package com.hrp.hotel.microservice.hotel.infrastructure.inputports;

import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelRequest;
import com.hrp.hotel.microservice.hotel.domain.Hotel;
import jakarta.persistence.EntityNotFoundException;

public interface CreateHotelInputPort {
    Hotel createHotel(CreateHotelRequest createHotelRequest) throws Exception;
    Hotel findHotelById(Long id) throws EntityNotFoundException;
}
