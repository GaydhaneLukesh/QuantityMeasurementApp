/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet{

        public Feet(double value){
            if(Double.isNaN(value)) throw new IllegalArgumentException("This exception is thrown because value is not valid(Numeric)");
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

    public static class Inches{

        public Inches(double value){
            if(Double.isNaN(value)) throw new IllegalArgumentException("This exception is thrown because value is not valid(Numeric)");
            this.value = value;
        }

        private final double value;

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Inches inches = (Inches)obj;
            return Double.compare(inches.value, value) == 0;
        }

        @Override
        public int hashCode(){
            return Double.hashCode(value);    //“hashCode must return int, and Double.hashCode(double) is designed exactly for that.”
        }                                     //Double.hashCode(value) is a static method that: takes a double,returns an int.
    }

    public static void demonstrateFeetEquality(){
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println("Feet value f1, f2 are equal: "+f1.equals(f2));
    }

    public static void demonstrateInchesEquality(){
        Inches in1 = new Inches(1.0);
        Inches in2 = new Inches(1.0);
        System.out.println("Inches value in1, in1 are equal: "+in1.equals(in2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}