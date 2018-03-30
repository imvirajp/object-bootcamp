package com.step.bootcamp.lengths;

import java.util.Objects;

// Understands to do feet measurements
public class Feet {
    private final double value;

    public Feet(double value) {
        this.value = value;
    }

    public Feet inFeet() {
        return new Feet(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feet feet = (Feet) o;
        return Double.compare(feet.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
