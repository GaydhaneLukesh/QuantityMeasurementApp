/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.dto.genericEnumDTO;

import com.apps.quantitymeasurement.dto.IMeasurableUnit;

public enum VolumeUnit implements IMeasurableUnit {
    MILLILITRE,
    LITRE,
    GALLON;

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }
}
