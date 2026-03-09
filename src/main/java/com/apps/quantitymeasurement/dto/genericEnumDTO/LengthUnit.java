/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.dto.genericEnumDTO;

import com.apps.quantitymeasurement.dto.IMeasurableUnit;

public enum LengthUnit implements IMeasurableUnit {
    FEET,
    INCHES,
    YARDS,
    CENTIMETERS;

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }
}
