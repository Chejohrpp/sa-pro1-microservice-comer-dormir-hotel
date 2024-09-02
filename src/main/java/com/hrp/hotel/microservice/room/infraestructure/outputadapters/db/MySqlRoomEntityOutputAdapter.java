package com.hrp.hotel.microservice.room.infraestructure.outputadapters.db;

import com.hrp.hotel.microservice.common.annotation.PersistenceAdapter;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.infraestructure.outputports.RoomPersistencePort;

import java.util.Optional;

@PersistenceAdapter
public class MySqlRoomEntityOutputAdapter implements RoomPersistencePort {
    private final JpaRoomEntityRepository jpaRoomEntityRepository;

    public MySqlRoomEntityOutputAdapter(JpaRoomEntityRepository jpaRoomEntityRepository) {
        this.jpaRoomEntityRepository = jpaRoomEntityRepository;
    }

    @Override
    public void saveRoom(Room room) {
        RoomEntity roomEntity = RoomEntity.from(room);
        jpaRoomEntityRepository.save(roomEntity);
    }

    /*
        return a new Hotel(id, null, null)
     */
    @Override
    public Optional<Room> findRoomByName(String name) {
        return jpaRoomEntityRepository.findByName(name)
                .map(RoomEntity::toDomain);
    }

    @Override
    public Optional<Room> findByNameAndIdHotel(String name, Long hotelId) {
        return jpaRoomEntityRepository.findByNameAndHotel(name, hotelId)
                .map(RoomEntity::toDomain);
    }
}
