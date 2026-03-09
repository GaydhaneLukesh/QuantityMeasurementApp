/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.genericEnum.LengthUnit;
import com.apps.quantitymeasurement.genericEnum.WeightUnit;
import com.apps.quantitymeasurement.interfaces.IMeasurable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testIMeasurableInterface_LengthUnitImplementation() {
        IMeasurable unit = LengthUnit.FEET;

        double base = unit.convertToBaseUnit(1.0);
        double value = unit.convertFromBaseUnit(base);

        assertEquals(12.0, base, 0.0001);
        assertEquals(1.0, value, 0.0001);
    }

    @Test
    public void testIMeasurableInterface_WeightUnitImplementation() {
        IMeasurable unit = WeightUnit.KILOGRAM;

        double base = unit.convertToBaseUnit(1.0);
        double value = unit.convertFromBaseUnit(base);

        assertEquals(1000.0, base, 0.0001);
        assertEquals(1.0, value, 0.0001);
    }

    @Test
    public void testIMeasurableInterface_ConsistentBehavior() {
        IMeasurable length = LengthUnit.FEET;
        IMeasurable weight = WeightUnit.KILOGRAM;

        double lBase = length.convertToBaseUnit(2.0);
        double wBase = weight.convertToBaseUnit(2.0);

        assertTrue(lBase > 0);
        assertTrue(wBase > 0);
    }
}
