package com.hrp.hotel.microservice.maintenance.infrastructure.outputadapters.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMaintenanceEntityRepository extends JpaRepository<MaintenanceEntity, Long> {
}
