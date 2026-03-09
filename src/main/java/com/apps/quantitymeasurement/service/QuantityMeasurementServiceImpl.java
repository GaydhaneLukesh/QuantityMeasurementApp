/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.interfaces.IMeasurable;
import com.apps.quantitymeasurement.model.QuantityModel;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;

import java.util.function.DoubleBinaryOperator;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    private enum Operation {
        COMPARISON, CONVERSION, ARITHMETIC
    }

    private enum ArithmeticOperation {
        ADDITION, SUBTRACTION, DIVISION
    }

    @Override
    public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);

        return compareTo(q1, q2);
    }

    private <U extends IMeasurable> boolean compareTo(QuantityModel<U> q1, QuantityModel<U> q2){
        double base1 = q1.getUnit().convertToBaseUnit(q1.getValue());
        double base2 = q2.getUnit().convertToBaseUnit(q2.getValue());

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> source = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> target = getQuantityModel(thatQuantityDTO);

        double convertedValue = convertTo(source, target.getUnit());

        return new QuantityDTO(
                convertedValue,
                thatQuantityDTO.getUnit(),
                thisQuantityDTO.getMeasurementType()
        );
    }

    private <U extends IMeasurable> double convertTo(QuantityModel<U> source, U targetUnit){
        double baseValue = source.getUnit().convertToBaseUnit(source.getValue());
        double resultValue = targetUnit.convertFromBaseUnit(baseValue);
        return resultValue;
    }

    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {

        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);

        validateArithmeticOperands(q1, q2, null, false);
        double result = performArithmetic(q1, q2, null, ArithmeticOperation.ADDITION);

        return new QuantityDTO(
                result,
                thisQuantityDTO.getUnit(),
                thatQuantityDTO.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {

        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);
        QuantityModel<IMeasurable> target = getQuantityModel(targetUnitDTO);

        validateArithmeticOperands(q1, q2, target.getUnit(), true);

        double result = performArithmetic(q1, q2, target.getUnit(), ArithmeticOperation.ADDITION);

        return new QuantityDTO(
                result,
                targetUnitDTO.getUnit(),
                targetUnitDTO.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {

        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);

        validateArithmeticOperands(q1, q2, null, false);
        double result = performArithmetic(q1, q2, null, ArithmeticOperation.SUBTRACTION);

        return new QuantityDTO(
                result,
                thisQuantityDTO.getUnit(),
                thisQuantityDTO.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {

        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);
        QuantityModel<IMeasurable> target = getQuantityModel(targetUnitDTO);

        validateArithmeticOperands(q1, q2, target.getUnit(), true);

        double result = performArithmetic(q1, q2, target.getUnit(), ArithmeticOperation.SUBTRACTION);

        return new QuantityDTO(
                result,
                targetUnitDTO.getUnit(),
                targetUnitDTO.getMeasurementType()
        );
    }

    @Override
    public QuantityDTO divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> q1 = getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> q2 = getQuantityModel(thatQuantityDTO);

        validateArithmeticOperands(q1, q2, null, false);
        double result = performArithmetic(q1, q2, null, ArithmeticOperation.DIVISION);

        return new QuantityDTO(result, "RATIO", "SCALAR");
    }

    private QuantityModel<IMeasurable> getQuantityModel(QuantityDTO dto) {
        IMeasurable unit = IMeasurable.getUnit(dto.getMeasurementType(), dto.getUnit());
        return new QuantityModel<>(dto.getValue(), unit);
    }

    private <U extends IMeasurable> void validateArithmeticOperands(
            QuantityModel<U> q1, QuantityModel<U> q2,
            U targetUnit, boolean targetRequired
    ) {
        if (q1 == null || q2 == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!q1.getUnit().getMeasurementType()
                .equals(q2.getUnit().getMeasurementType()))
            throw new IllegalArgumentException("Measurement types must match");

        if (targetRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit required");
    }

    private <U extends IMeasurable> double performArithmetic(
            QuantityModel<U> q1, QuantityModel<U> q2,
            U targetUnit, ArithmeticOperation operation
    ) {
        double base1 = q1.getUnit().convertToBaseUnit(q1.getValue());
        double base2 = q2.getUnit().convertToBaseUnit(q2.getValue());

        DoubleBinaryOperator op;

        switch (operation) {

            case ADDITION:
                op = Double::sum;
                break;

            case SUBTRACTION:
                op = (a, b) -> a - b;
                break;

            case DIVISION:
                op = (a, b) -> a / b;
                break;

            default:
                throw new IllegalArgumentException("Invalid operation");
        }

        double baseResult = op.applyAsDouble(base1, base2);

        if(targetUnit == null) return baseResult;

        return targetUnit.convertFromBaseUnit(baseResult);
    }
}
