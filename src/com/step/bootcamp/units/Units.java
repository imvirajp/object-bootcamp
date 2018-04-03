package com.step.bootcamp.units;

import java.util.Objects;

import static com.step.bootcamp.units.UnitTypes.LENGTH;
import static com.step.bootcamp.units.UnitTypes.VOLUME;
import static com.step.bootcamp.units.UnitTypes.WEIGHT;

public enum Units {
    FEET(12,LENGTH), INCH(1,LENGTH), CM(0.4,LENGTH), MM(0.04,LENGTH),
    GALLON(3.78d,VOLUME), LITER(1d,VOLUME),
    KG(1d,WEIGHT), TON(1000d,WEIGHT);

    private final double conversionFactor;
    private final UnitTypes type;

    Units(double conversionFactor, UnitTypes type) {
        this.conversionFactor = conversionFactor;
        this.type = type;
    }

    public double toBaseUnit(double value) {
        return value * conversionFactor;
    }

    public boolean isSameType(Units unit) {
        return this.type == unit.type;
    }

    public double toGivenUnit(double value, Units unit) {
        return value / unit.conversionFactor;
    }

    public int hash(double value) {
        return Objects.hash(toBaseUnit(value), type);
    }
}
