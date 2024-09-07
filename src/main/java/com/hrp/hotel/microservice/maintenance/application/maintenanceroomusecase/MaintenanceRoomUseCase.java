package com.hrp.hotel.microservice.maintenance.application.maintenanceroomusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.maintenance.domain.Maintenance;
import com.hrp.hotel.microservice.maintenance.infrastructure.inputports.MaintenanceRoomInputport;
import com.hrp.hotel.microservice.maintenance.infrastructure.outputports.PaidMaintenanceOutputPort;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@UseCase
@Transactional
public class MaintenanceRoomUseCase implements MaintenanceRoomInputport {
    private final PaidMaintenanceOutputPort paidMaintenanceOutputPort;
    private final RoomPersistencePort roomPersistencePort;

    @Autowired
    public MaintenanceRoomUseCase(PaidMaintenanceOutputPort paidMaintenanceOutputPort, RoomPersistencePort roomPersistencePort) {
        this.paidMaintenanceOutputPort = paidMaintenanceOutputPort;
        this.roomPersistencePort = roomPersistencePort;
    }


    @Override
    public void paidMaintenanceRoom(String roomName, Long hotelId, MaintenanceRoomRequest maintenanceRoomRequest) throws Exception {
        //verify if the room exists
        Room room = roomPersistencePort.findByNameAndIdHotel(roomName, hotelId)
                .orElseThrow(() -> new EntityNotFoundException("room not found"));

        //create the maintenance
        Maintenance maintenance = maintenanceRoomRequest.toDomain(room);

        //save the maintenance
        paidMaintenanceOutputPort.save(maintenance);
    }
}
