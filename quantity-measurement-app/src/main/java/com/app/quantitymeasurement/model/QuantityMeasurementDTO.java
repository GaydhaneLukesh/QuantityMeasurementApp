package com.app.quantitymeasurement.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class QuantityMeasurementDTO {

    public double thisValue;
    public String thisUnit;
    public String thisMeasurementType;

    public double thatValue;
    public String thatUnit;
    public String thatMeasurementType;

    public String operation;

    public String resultString;
    public double resultValue;
    public String resultUnit;
    public String resultMeasurementType;

    @JsonProperty("error")
    public boolean error;

    public String errorMessage;

    public static QuantityMeasurementDTO from(QuantityMeasurementEntity entity) {
        if (entity == null) {
            return null;
        }

        QuantityMeasurementDTO dto = new QuantityMeasurementDTO();

        dto.thisValue = entity.getThisValue();
        dto.thisUnit = entity.getThisUnit();
        dto.thisMeasurementType = entity.getThisMeasurementType();

        dto.thatValue = entity.getThatValue();
        dto.thatUnit = entity.getThatUnit();
        dto.thatMeasurementType = entity.getThatMeasurementType();

        dto.operation = entity.getOperation();

        dto.resultString = entity.getResultString();
        dto.resultValue = entity.getResultValue();
        dto.resultUnit = entity.getResultUnit();
        dto.resultMeasurementType = entity.getResultMeasurementType();

        dto.error = entity.isError();
        dto.errorMessage = entity.getErrorMessage();

        return dto;
    }

    public QuantityMeasurementEntity toEntity() {
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

        entity.setThisValue(this.thisValue);
        entity.setThisUnit(this.thisUnit);
        entity.setThisMeasurementType(this.thisMeasurementType);

        entity.setThatValue(this.thatValue);
        entity.setThatUnit(this.thatUnit);
        entity.setThatMeasurementType(this.thatMeasurementType);

        entity.setOperation(this.operation);

        entity.setResultString(this.resultString);
        entity.setResultValue(this.resultValue);
        entity.setResultUnit(this.resultUnit);
        entity.setResultMeasurementType(this.resultMeasurementType);

        entity.setError(this.error);
        entity.setErrorMessage(this.errorMessage);

        return entity;
    }

    public static List<QuantityMeasurementDTO> fromList(List<QuantityMeasurementEntity> entities) {
        return entities.stream()
                .map(QuantityMeasurementDTO::from)
                .collect(Collectors.toList());
    }

    public static List<QuantityMeasurementEntity> toEntityList(List<QuantityMeasurementDTO> dtos) {
        return dtos.stream()
                .map(QuantityMeasurementDTO::toEntity)
                .collect(Collectors.toList());
    }
}