package com.hrp.hotel.microservice.room.infraestructure.outputadapters.db;

import com.hrp.hotel.microservice.hotel.domain.Hotel;
import com.hrp.hotel.microservice.hotel.infrastructure.outputadapters.db.HotelEntity;
import com.hrp.hotel.microservice.room.domain.Room;
import com.hrp.hotel.microservice.room.domain.TypeRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeRoom type;
    @Column(nullable = false)
    private boolean availability;
    @Column(nullable = false)
    private double pricePerNight;
    @Column(name = "id_hotel")
    private Long hotel;

    public RoomEntity(String name, TypeRoom type, boolean availability, double pricePerNight, Long hotel) {
        this.name = name;
        this.type = type;
        this.availability = availability;
        this.pricePerNight = pricePerNight;
        this.hotel = hotel;
    }

    public static RoomEntity from(Room room) {
        return new RoomEntity(
                room.getName(),
                room.getType(),
                room.isAvailability(),
                room.getPricePerNight(),
                room.getHotel().getId()
        );
    }

    public Room toDomain(){
        return Room.builder()
                .id(id)
                .name(name)
                .type(type)
                .availability(availability)
                .pricePerNight(pricePerNight)
                .hotel(Hotel.builder().id(hotel).build())
                .build();
    }
}
