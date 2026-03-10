/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.interfaces.IMeasurable;
import com.apps.quantitymeasurement.entity.QuantityModel;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;

import java.util.List;

public class QuantityMeasurementAuditService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementAuditService(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    public void logSuccess(
            QuantityModel<IMeasurable> q1,
            QuantityModel<IMeasurable> q2,
            String operation,
            QuantityModel<IMeasurable> result
    ){
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(q1, q2, operation, result);

        repository.save(entity);
    }

    public void logComparison(
            QuantityModel<IMeasurable> q1,
            QuantityModel<IMeasurable> q2,
            String operation,
            boolean result
    ){
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(q1, q2, operation, String.valueOf(result));

        repository.save(entity);
    }

    public void logError(
            QuantityModel<IMeasurable> q1,
            QuantityModel<IMeasurable> q2,
            String operation,
            String message
    ){
        QuantityMeasurementEntity entity =
                new QuantityMeasurementEntity(q1, q2, operation, message, true);

        repository.save(entity);
    }

    public List<QuantityMeasurementEntity> getAllAuditMeasurements() {
        return repository.getAllMeasurements();
    }
}
