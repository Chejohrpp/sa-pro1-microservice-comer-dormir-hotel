package com.hrp.hotel.microservice.room.domain;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Room {

    private int id;
    private String name;
    private TypeRoom type;
    private boolean availability;
    private double pricePerNight;
    private Hotel hotel;
}
