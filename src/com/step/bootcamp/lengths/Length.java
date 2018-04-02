package com.step.bootcamp.lengths;

import java.util.Objects;

public class Length {
    private final double value;
    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length inInches(double valueInInches) {
        return new Length(valueInInches, Unit.INCH);
    }

    public static Length inFeet(double valueInFeet) {
        return new Length(valueInFeet, Unit.FEET);
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

    public static Length inCentimeter(double value) {
        return new Length(value,Unit.CM);
    }
}