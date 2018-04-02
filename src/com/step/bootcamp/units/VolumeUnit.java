package com.step.bootcamp.units;

// Understands to represent unit with it's conversion factor

public enum VolumeUnit {
    GALLON(3.78d), LITER(1d);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toLiters(double value) {
        return value * conversionFactor;
    }
}