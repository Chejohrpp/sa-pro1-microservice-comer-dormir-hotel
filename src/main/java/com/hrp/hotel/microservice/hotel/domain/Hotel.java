package com.hrp.hotel.microservice.hotel.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Hotel {

    private int id;
    private String name;
    private String address;
}
