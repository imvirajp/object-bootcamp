package com.step.bootcamp.lengths;

import java.util.Objects;

public class Length {
    private final double value;
    private final Unit unit;
    private final double inches;

    public enum Unit {
        FEET, INCH
    }

    private Length(double value, Unit unit, double inches) {
        this.value = value;
        this.unit = unit;
        this.inches = inches;
    }

    public static Length inInches(double valueInInches) {
        return new Length(valueInInches,Length.Unit.INCH,valueInInches);
    }

    public static Length inFeet(double valueInFeet) {
        double valueInInches = valueInFeet * 12;
        return new Length(valueInFeet, Length.Unit.FEET,valueInInches);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.inches, inches) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inches);
    }
}