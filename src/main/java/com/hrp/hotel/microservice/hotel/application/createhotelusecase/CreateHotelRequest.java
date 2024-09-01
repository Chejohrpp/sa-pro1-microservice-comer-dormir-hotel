package com.hrp.hotel.microservice.hotel.application.createhotelusecase;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import lombok.Value;

@Value
public class CreateHotelRequest {
    int id;
    String name;
    String address;

    public CreateHotelRequest(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Hotel toHotel() {
        return Hotel.builder()
                .id(id)
                .name(name)
                .address(address)
                .build();
    }
}
