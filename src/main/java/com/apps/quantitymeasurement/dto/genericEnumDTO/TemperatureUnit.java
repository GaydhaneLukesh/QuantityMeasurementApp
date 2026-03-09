/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.dto.genericEnumDTO;

import com.apps.quantitymeasurement.dto.IMeasurableUnit;

public enum TemperatureUnit implements IMeasurableUnit {
    CELSIUS,
    FAHRENHEIT,
    KELVIN;

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }
}
