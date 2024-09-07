package com.hrp.hotel.microservice.maintenance.infrastructure.outputadapters.db;

import com.hrp.hotel.microservice.maintenance.domain.Maintenance;
import com.hrp.hotel.microservice.room.domain.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int roomId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "price", nullable = false)
    private double price;

    public MaintenanceEntity(int roomId, LocalDate date, double price) {
        this.roomId = roomId;
        this.date = date;
        this.price = price;
    }

    public static MaintenanceEntity from(Maintenance maintenance) {
        return new MaintenanceEntity(
                maintenance.getRoom().getId(),
                maintenance.getDate(),
                maintenance.getPrice()
        );
    }

    public Maintenance toDomain(Room room){
        return Maintenance.builder()
                .id(id)
                .room(room)
                .date(date)
                .price(price)
                .build();
    }
}
