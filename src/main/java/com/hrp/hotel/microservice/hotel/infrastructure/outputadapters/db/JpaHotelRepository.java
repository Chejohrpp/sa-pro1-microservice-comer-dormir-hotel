package com.hrp.hotel.microservice.hotel.infrastructure.outputadapters.db;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaHotelRepository extends JpaRepository<HotelEntity, Integer> {

}
