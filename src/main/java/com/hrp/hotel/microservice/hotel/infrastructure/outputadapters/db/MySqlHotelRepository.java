package com.hrp.hotel.microservice.hotel.infrastructure.outputadapters.db;

import com.hrp.hotel.microservice.common.annotation.PersistenceAdapter;
import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.infrastructure.outputports.db.HotelPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@PersistenceAdapter
public class MySqlHotelRepository implements HotelPersistencePort {
    private final JpaHotelRepository jpaHotelRepository;

    @Autowired
    public MySqlHotelRepository(JpaHotelRepository jpaHotelRepository) {
        this.jpaHotelRepository = jpaHotelRepository;
    }

    @Override
    public void saveHotel(Hotel hotel) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName(hotel.getName());
        hotelEntity.setAddress(hotel.getAddress());
        jpaHotelRepository.save(hotelEntity);
    }

    @Override
    public Optional<Hotel> findHotelById(Long id) {
        return jpaHotelRepository.findById(id)
                .map(HotelEntity::convertToDomain);
    }
}
