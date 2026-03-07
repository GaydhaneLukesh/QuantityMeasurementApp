/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement.interfaces;

public interface IMeasurable {
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double baseValue);

    default SupportsArithmetic supportsArithmetic(){
        return ()-> true;
    }

    default void validateOperationSupport(String operation){
    }
}
