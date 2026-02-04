/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static void demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2
    ){
        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        System.out.println(l1.equals(l2));
    }

    public static void demonstrateLengthConversion(
            double value,
            LengthUnit fromUnit,
            LengthUnit toTargetUnit
    ){
        Length l = new Length(value, fromUnit);
        double resultValue = l.convertTo(toTargetUnit);
        System.out.println(value+" "+fromUnit+" = "+resultValue+" "+toTargetUnit);
    }

    public static void main(String[] args) {
        demonstrateLengthComparison(
                1.0, LengthUnit.FEET,
                12.0,LengthUnit.INCHES);

        demonstrateLengthConversion(5.0, LengthUnit.YARDS, LengthUnit.INCHES);
    }
}