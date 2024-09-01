package com.hrp.hotel.microservice.hotel.infrastructure.inputports;

import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelRequest;
import com.hrp.hotel.microservice.hotel.domain.Hotel;

public interface CreateHotelInputPort {
    Hotel createHotel(CreateHotelRequest createHotelRequest) throws Exception;
}
