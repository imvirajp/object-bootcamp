package com.step.bootcamp.units;

import java.util.Objects;

import static com.step.bootcamp.units.UnitTypes.LENGTH;
import static com.step.bootcamp.units.UnitTypes.VOLUME;
import static com.step.bootcamp.units.UnitTypes.WEIGHT;

public enum Unit {
    FEET(Constants.A_FOOT_IN_INCH,LENGTH), INCH(Constants.AN_INCH,LENGTH),
    CM(Constants.A_CENTIMETER_IN_INCH,LENGTH), MM(Constants.A_MILLIMETER_IN_INCH,LENGTH),
    GALLON(Constants.A_GALLON_IN_LITER,VOLUME), LITER(Constants.A_LITER,VOLUME),
    KG(Constants.A_KILOGRAM,WEIGHT), TON(Constants.A_TON_IN_KILOGRAM,WEIGHT),
    GM(Constants.A_GRAM_IN_KILOGRAM,WEIGHT);

    private final double valueInBaseUnit;
    private final UnitTypes type;

    Unit(double valueInBaseUnit, UnitTypes type) {
        this.valueInBaseUnit = valueInBaseUnit;
        this.type = type;
    }

    private double toBaseUnit(double value) {
        return value * valueInBaseUnit;
    }

    public boolean isNotSameType(Unit unit) {
        return this.type != unit.type;
    }

    public int hash(double value) {
        return Objects.hash(toBaseUnit(value),type);
    }

    public double toUnit(Unit unit, double value) throws IncompatibleTypeConversionException {
        if (isNotSameType(unit)) throw new IncompatibleTypeConversionException();
        return value*valueInBaseUnit/unit.valueInBaseUnit;
    }

    private static class Constants {
        private static final int A_FOOT_IN_INCH = 12;
        private static final int AN_INCH = 1;
        private static final double A_CENTIMETER_IN_INCH = 0.4;
        private static final double A_MILLIMETER_IN_INCH = 0.04;
        private static final double A_GALLON_IN_LITER = 3.78;
        private static final int A_LITER = 1;
        private static final int A_KILOGRAM = 1;
        private static final int A_TON_IN_KILOGRAM = 1000;
        private static final double A_GRAM_IN_KILOGRAM = 0.001;
    }
}