package com.hrp.hotel.microservice.hotel.application.createhotelusecase;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.domain.HotelRepository;
import jakarta.transaction.Transactional;

@Transactional
public class CreateHotelUseCase {
    private final HotelRepository hotelRepository;

    public CreateHotelUseCase(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void useCase(CreateHotelRequest createHotelRequest) {
        Hotel hotel = createHotelRequest.toHotel();
        hotelRepository.save(hotel);
    }
}
