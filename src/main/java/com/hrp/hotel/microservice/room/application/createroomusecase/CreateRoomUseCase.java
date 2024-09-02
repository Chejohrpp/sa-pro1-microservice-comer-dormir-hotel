package com.hrp.hotel.microservice.room.application.createroomusecase;

import com.hrp.hotel.microservice.common.annotation.UseCase;
import com.hrp.hotel.microservice.common.exceptions.EntityAlreadyExistsException;
import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.CreateHotelInputPort;
import com.hrp.hotel.microservice.hotel.infrastructure.outputports.db.HotelPersistencePort;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.infraestructure.inputports.CreateRoomInputPort;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

@UseCase
@Transactional
public class CreateRoomUseCase implements CreateRoomInputPort {
    private final RoomPersistencePort roomPersistencePort;
    private final HotelPersistencePort hotelPersistencePort;

    @Autowired
    public CreateRoomUseCase(RoomPersistencePort roomPersistencePort, HotelPersistencePort hotelPersistencePort) {
        this.roomPersistencePort = roomPersistencePort;
        this.hotelPersistencePort = hotelPersistencePort;
    }

    @Override
    public void createRoom(Long idHotel, CreateRoomRequest createRoomRequest) throws EntityNotFoundException, EntityAlreadyExistsException {
        //validate the hotel
        Hotel hotel =  hotelPersistencePort.findHotelById(idHotel)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));

        //validate the room name
        Optional<Room> isRoom = roomPersistencePort.findByNameAndIdHotel(createRoomRequest.getName(), hotel.getId());

        if(isRoom.isPresent()) {
                throw new EntityAlreadyExistsException("Room already exists");
        }

        //always convert to domain
        Room room = createRoomRequest.toDomain();
        room.setAvailability(true);
        room.setHotel(hotel);
        // validate the domain rules

        //add to the db
        roomPersistencePort.saveRoom(room);
    }
}
