package com.step.bootcamp.units;

// Understands to represent unit with it's conversion factor

public enum LengthUnit {
        FEET(12), INCH(1), CM(0.4), MM(0.04);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double toInches(double value) {
        return (double) Math.round((value * conversionFactor)*100)/100;
    }
}
