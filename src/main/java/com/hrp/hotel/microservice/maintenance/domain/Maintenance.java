package com.hrp.hotel.microservice.maintenance.domain;

import com.hrp.hotel.microservice.room.domain.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Maintenance {
    private Long id;
    private Room room;
    private LocalDate date;
    private double price;
}
