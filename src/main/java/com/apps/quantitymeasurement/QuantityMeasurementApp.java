/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import org.omg.DynamicAny.DynSequenceOperations;

public class QuantityMeasurementApp {

    public static class Feet{

        public Feet(double value){
            this.value = value;
        }

        private final double value;

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet)obj;
            return Double.compare(feet.value, value) == 0;
        }

        @Override
        public int hashCode(){
            return Double.hashCode(value);
        }

    }

    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println(f1.equals(f2));
    }
}