/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.dto.genericEnumDTO;

import com.apps.quantitymeasurement.dto.IMeasurableUnit;

public enum WeightUnit implements IMeasurableUnit {
    MILLIGRAM,
    GRAM,
    KILOGRAM,
    POUND,
    TONNE;

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }
}
