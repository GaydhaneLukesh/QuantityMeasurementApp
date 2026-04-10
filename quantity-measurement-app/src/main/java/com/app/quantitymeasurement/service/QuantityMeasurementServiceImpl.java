package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.model.QuantityDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementDTO;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{

    private static final Logger logger = Logger.getLogger(
            QuantityMeasurementServiceImpl.class.getName()
    );

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementDTO compare(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    ) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        return null;
    }

    @Override
    public QuantityMeasurementDTO divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        return null;
    }

    @Override
    public List<QuantityMeasurementDTO> getOperationHistory(String operation) {
        return null;
    }

    @Override
    public List<QuantityMeasurementDTO> getMeasurementByType(String type) {
        return null;
    }

    @Override
    public long getOperationCount(String operation) {
        return 0;
    }

    @Override
    public List<QuantityMeasurementDTO> getErrorHistory() {
        return null;
    }
}
