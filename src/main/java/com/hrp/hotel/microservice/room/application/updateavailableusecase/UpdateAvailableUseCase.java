package com.hrp.hotel.microservice.room.application.updateavailableusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.infraestructure.inputports.UpdateAvailableInputPort;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@UseCase
@Transactional
public class UpdateAvailableUseCase implements UpdateAvailableInputPort {
    private final RoomPersistencePort roomPersistencePort;

    @Autowired
    public UpdateAvailableUseCase(RoomPersistencePort roomPersistencePort) {
        this.roomPersistencePort = roomPersistencePort;
    }

    @Override
    public boolean updateAvailable(Long hotelId, String roomNumber, Boolean available) throws EntityNotFoundException {
        //find the room
        Room room = roomPersistencePort.findByNameAndIdHotel(roomNumber, hotelId)
                .orElseThrow(() -> new EntityNotFoundException("room not found"));

        //update the status room
        room.setAvailability(available);

        //save in the db
        return roomPersistencePort.updateRoomAvailable(room);
    }
}
