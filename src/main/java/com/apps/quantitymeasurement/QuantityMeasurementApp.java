/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static void demostrateLengthEquality(){
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println(l1.equals(l2));
    }

    public static void demonstrateFeetEquality(){
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);
        System.out.println(f1.equals(f2));
    }

    public static void demonstrateInchesEquality(){
        Length in1 = new Length(12.0, LengthUnit.INCHES);
        Length in2 = new Length(12.0, LengthUnit.INCHES);
        System.out.println(in1.equals(in2));
    }

    public static void demonstrateFeetInchesComparison(){
        Length f = new Length(1.0, LengthUnit.FEET);
        Length in = new Length(12.0, LengthUnit.INCHES);
        System.out.println(f.equals(in));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}