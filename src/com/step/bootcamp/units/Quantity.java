package com.step.bootcamp.units;

// Understands to represent comparison of given units

public class Quantity {
    private final double value;
    private final Unit unit;

    private Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Quantity inInches(double valueInInches) {
        return new Quantity(valueInInches, Unit.INCH);
    }

    public static Quantity inFeet(double valueInFeet) {
        return new Quantity(valueInFeet, Unit.FEET);
    }

    public static Quantity inCentimeters(double value) {
        return new Quantity(value, Unit.CM);
    }

    public static Quantity inMillimeters(double value) {
        return new Quantity(value, Unit.MM);
    }

    public static Quantity inGallons(double value) {
        return new Quantity(value, Unit.GALLON);
    }

    public static Quantity inLiters(double value) {
        return new Quantity(value, Unit.LITER);
    }

    public static Quantity inKilograms(double value) {
        return new Quantity(value, Unit.KG);
    }

    public static Quantity inTonnes(double value) {
        return new Quantity(value, Unit.TON);
    }

    public Quantity add(Quantity other) throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        validateSameType(other);
        double otherBaseValue = other.unit.toUnit(unit,other.value);
        double valueInBaseUnit = value + otherBaseValue;
        return new Quantity(valueInBaseUnit, unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity measurement = (Quantity) o;
        try {
            return compareBaseValue(measurement);
        } catch (IncompatibleUnitTypeException | IncompatibleTypeConversionException e) {
            return false;
        }
    }

    private void validateSameType(Quantity other) throws IncompatibleUnitTypeException {
        if (unit.isNotSameType(other.unit)) throw new IncompatibleUnitTypeException();
    }

    private boolean compareBaseValue(Quantity measurement) throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        validateSameType(measurement);
        double baseValue = unit.toUnit(unit,value);
        double otherBaseValue = measurement.unit.toUnit(unit,measurement.value);
        return Double.compare(baseValue,otherBaseValue)==0;
    }

    @Override
    public int hashCode() {
        return unit.hash(value);
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public Quantity toUnit(Unit standardUnit) throws IncompatibleTypeConversionException {
        double result = unit.toUnit(standardUnit,value);
        return new Quantity(result,standardUnit);
    }
}