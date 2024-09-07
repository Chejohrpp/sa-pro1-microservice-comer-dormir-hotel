package com.hrp.hotel.microservice.maintenance.infrastructure.outputports;

import com.hrp.hotel.microservice.maintenance.domain.Maintenance;
import com.hrp.hotel.microservice.maintenance.infrastructure.outputadapters.db.MaintenanceEntity;

public interface PaidMaintenanceOutputPort {
    Maintenance save(Maintenance maintenance);
}
