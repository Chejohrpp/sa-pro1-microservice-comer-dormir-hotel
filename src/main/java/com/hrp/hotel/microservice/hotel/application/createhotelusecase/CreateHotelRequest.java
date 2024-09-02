package com.hrp.hotel.microservice.hotel.application.createhotelusecase;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import lombok.Value;

@Value
public class CreateHotelRequest {
    String name;
    String address;

    public CreateHotelRequest(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Hotel toHotel() {
        return Hotel.builder()
                .name(name)
                .address(address)
                .build();
    }
}
