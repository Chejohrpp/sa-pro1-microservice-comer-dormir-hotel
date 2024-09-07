package com.hrp.hotel.microservice.maintenance.infrastructure.inputports;

import com.hrp.hotel.microservice.maintenance.application.maintenanceroomusecase.MaintenanceRoomRequest;
import com.hrp.hotel.microservice.room.domain.Room;

import java.time.LocalDate;

public interface MaintenanceRoomInputport {
    void paidMaintenanceRoom(String roomName, Long hotelId, MaintenanceRoomRequest maintenanceRoomRequest) throws Exception;
}
