package com.step.bootcamp.units;

import java.util.Objects;

// Understands to represent comparison of given units

public class Length {
    private final double value;
    private final LengthUnit unit;

    private Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length inInches(double valueInInches) {
        return new Length(valueInInches, LengthUnit.INCH);
    }

    public static Length inFeet(double valueInFeet) {
        return new Length(valueInFeet, LengthUnit.FEET);
    }

    public static Length inCentimeters(double value) {
        return new Length(value, LengthUnit.CM);
    }

    public static Length inMillimeters(double value) {
        return new Length(value, LengthUnit.MM);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.unit.toInches(length.value),
                this.unit.toInches(this.value))==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}