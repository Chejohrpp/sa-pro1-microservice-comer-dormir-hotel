package com.hrp.hotel.microservice.room.application.createroomusecase;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.domain.TypeRoom;
import lombok.Value;

@Value
public class CreateRoomRequest {
    String name;
    TypeRoom type;
    double price;

    public CreateRoomRequest(String name, double price, TypeRoom type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Room toDomain() {
        return Room.builder()
                .name(name)
                .type(type)
                .pricePerNight(price)
                .build();
    }
}
