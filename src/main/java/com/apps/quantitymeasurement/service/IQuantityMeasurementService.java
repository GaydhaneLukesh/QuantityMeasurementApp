/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.QuantityDTO;

public interface IQuantityMeasurementService {
    public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO);
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO);
    public QuantityDTO divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
}
