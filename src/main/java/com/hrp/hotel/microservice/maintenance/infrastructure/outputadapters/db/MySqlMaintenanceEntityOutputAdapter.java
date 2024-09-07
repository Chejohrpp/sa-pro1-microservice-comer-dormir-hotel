package com.hrp.hotel.microservice.maintenance.infrastructure.outputadapters.db;

import com.hrp.hotel.microservice.common.annotation.PersistenceAdapter;
import com.hrp.hotel.microservice.maintenance.domain.Maintenance;
import com.hrp.hotel.microservice.maintenance.infrastructure.outputports.PaidMaintenanceOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

@PersistenceAdapter
public class MySqlMaintenanceEntityOutputAdapter implements PaidMaintenanceOutputPort {
    private final JpaMaintenanceEntityRepository jpaMaintenanceEntityRepository;

    @Autowired
    public MySqlMaintenanceEntityOutputAdapter(JpaMaintenanceEntityRepository jpaMaintenanceEntityRepository) {
        this.jpaMaintenanceEntityRepository = jpaMaintenanceEntityRepository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        MaintenanceEntity maintenanceEntity =  MaintenanceEntity.from(maintenance);
        return jpaMaintenanceEntityRepository.save(maintenanceEntity)
                .toDomain(maintenance.getRoom());
    }
}
