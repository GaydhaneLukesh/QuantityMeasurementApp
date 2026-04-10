package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.model.QuantityDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementDTO;

import java.util.List;

public interface IQuantityMeasurementService {

    public QuantityMeasurementDTO compare(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    );

    public QuantityMeasurementDTO convert(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    );

    public QuantityMeasurementDTO add(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    );

    public QuantityMeasurementDTO add(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO,
            QuantityDTO targetUnitDTO
    );

    public QuantityMeasurementDTO subtract(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    );

    public QuantityMeasurementDTO subtract(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO,
            QuantityDTO targetUnitDTO
    );

    public QuantityMeasurementDTO divide(
            QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO
    );

    List<QuantityMeasurementDTO> getOperationHistory(String operation);

    List<QuantityMeasurementDTO> getMeasurementByType(String type);

    long getOperationCount(String operation);

    List<QuantityMeasurementDTO> getErrorHistory();
}
