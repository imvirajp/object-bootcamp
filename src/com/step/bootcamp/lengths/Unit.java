package com.step.bootcamp.lengths;

public enum Unit {
        FEET(12), INCH(1), CM(0.4);

    private final double conversionFactor;

    Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double toInches(double value) {
        return value * conversionFactor;
    }
}
