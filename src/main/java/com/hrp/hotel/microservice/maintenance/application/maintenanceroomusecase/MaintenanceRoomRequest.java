package com.hrp.hotel.microservice.maintenance.application.maintenanceroomusecase;

import com.hrp.hotel.microservice.maintenance.domain.Maintenance;
import com.hrp.hotel.microservice.room.domain.Room;
import lombok.Value;

import java.time.LocalDate;

@Value
public class MaintenanceRoomRequest {
    private LocalDate date;
    private double price;

    public Maintenance toDomain(Room room){
        return Maintenance.builder()
                .room(room)
                .price(price)
                .date(date)
                .build();
    }
}
