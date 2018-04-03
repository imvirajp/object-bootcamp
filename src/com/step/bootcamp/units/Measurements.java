package com.step.bootcamp.units;

import java.util.Objects;

// Understands to represent comparison of given units

public class Measurements {
    private final double value;
    private final Units unit;

    private Measurements(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Measurements inInches(double valueInInches) {
        return new Measurements(valueInInches, Units.INCH);
    }

    public static Measurements inFeet(double valueInFeet) {
        return new Measurements(valueInFeet, Units.FEET);
    }

    public static Measurements inCentimeters(double value) {
        return new Measurements(value, Units.CM);
    }

    public static Measurements inMillimeters(double value) {
        return new Measurements(value, Units.MM);
    }

    public static Measurements inGallons(double value) {
        return new Measurements(value, Units.GALLON);
    }

    public static Measurements inLiters(double value) {
        return new Measurements(value,Units.LITER);
    }

    public static Measurements inKilograms(double value) {
        return new Measurements(value, Units.KG);
    }

    public static Measurements inTonnes(double value) {
        return new Measurements(value,Units.TON);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurements measurement = (Measurements) o;
        return compareBaseValue(measurement);
    }

    private boolean compareBaseValue(Measurements measurement) {
        return unit.isSameType(measurement.unit) &&
                Double.compare(getBaseUnit(measurement),
                getBaseUnit(this))==0;
    }

    private double getBaseUnit(Measurements measurement) {
        return measurement.unit.toBaseUnit(measurement.value);
    }

    @Override
    public int hashCode() {
        return unit.hash(value);
//        return Objects.hash(unit.toBaseUnit(value), unit);
    }

    @Override
    public String toString() {
        return "Measurements{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public Measurements add(Measurements other) throws IncompatibleUnitTypeException {
        if (!unit.isSameType(other.unit)) throw new IncompatibleUnitTypeException();
        double baseValue = getBaseUnit(this);
        double otherBaseValue = getBaseUnit(other);
        double result = unit.toGivenUnit(baseValue + otherBaseValue,this.unit);
        return new Measurements(result,this.unit);
    }
}