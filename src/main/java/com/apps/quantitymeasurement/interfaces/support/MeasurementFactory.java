/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.interfaces.support;

import com.apps.quantitymeasurement.genericEnum.LengthUnit;
import com.apps.quantitymeasurement.genericEnum.TemperatureUnit;
import com.apps.quantitymeasurement.genericEnum.VolumeUnit;
import com.apps.quantitymeasurement.genericEnum.WeightUnit;
import com.apps.quantitymeasurement.interfaces.IMeasurable;

public class MeasurementFactory {

    public static IMeasurable getUnit(String measurementType, String unitName) {

        switch (measurementType.toLowerCase()) {

            case "length":
                return LengthUnit.valueOf(unitName.toUpperCase());

            case "weight":
                return WeightUnit.valueOf(unitName.toUpperCase());

            case "volume":
                return VolumeUnit.valueOf(unitName.toUpperCase());

            case "temperature":
                return TemperatureUnit.valueOf(unitName.toUpperCase());

            default:
                throw new IllegalArgumentException("Invalid measurement type: " + measurementType);
        }
    }
}
