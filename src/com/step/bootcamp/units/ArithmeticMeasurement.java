package com.step.bootcamp.units;

import static com.step.bootcamp.units.Unit.*;

public class ArithmeticMeasurement extends Quantity {
    private ArithmeticMeasurement(double value, Unit unit) {
        super(value, unit);
    }

    public static ArithmeticMeasurement inInches(double valueInInches) {
        return new ArithmeticMeasurement(valueInInches, INCH);
    }

    public static ArithmeticMeasurement inFeet(double valueInFeet) {
        return new ArithmeticMeasurement(valueInFeet, FEET);
    }

    public static ArithmeticMeasurement inCentimeters(double value) {
        return new ArithmeticMeasurement(value, CM);
    }

    public static ArithmeticMeasurement inMillimeters(double value) {
        return new ArithmeticMeasurement(value, MM);
    }

    public static ArithmeticMeasurement inGallons(double value) {
        return new ArithmeticMeasurement(value, GALLON);
    }

    public static ArithmeticMeasurement inLiters(double value) {
        return new ArithmeticMeasurement(value, LITER);
    }

    public static ArithmeticMeasurement inKilograms(double value) {
        return new ArithmeticMeasurement(value, KG);
    }

    public static ArithmeticMeasurement inTonnes(double value) {
        return new ArithmeticMeasurement(value, TON);
    }

    public ArithmeticMeasurement add(ArithmeticMeasurement other) throws IncompatibleUnitTypeException {
        if (unit.isNotSameType(other.unit)) throw new IncompatibleUnitTypeException("Cannot add quantities of different type!");
        double otherBaseValue = other.unit.toUnit(unit,other.value);
        double valueInBaseUnit = value + otherBaseValue;
        return new ArithmeticMeasurement(valueInBaseUnit, unit);
    }


    public ArithmeticMeasurement toUnit(Unit standardUnit) throws IncompatibleUnitTypeException {
        double result = unit.toUnit(standardUnit,value);
        return new ArithmeticMeasurement(result,standardUnit);
    }
}
