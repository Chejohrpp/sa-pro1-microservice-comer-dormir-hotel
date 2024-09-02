package com.hrp.hotel.microservice.hotel.infrastructure.outputadapters.db;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    public Hotel convertToDomain() {
        return Hotel.builder()
                .id(id)
                .address(address)
                .name(name)
                .build();
    }
}
