package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static com.step.bootcamp.units.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnitTest {

    private Unit oneLiter;
    private Unit oneKilogram;

    @Before
    public void setUp() {
        oneLiter = Unit.LITER;
        oneKilogram = Unit.KG;
    }

    @Test
    public void shouldConvertOneKilogramToThousandGrams() throws IncompatibleUnitTypeException {
        double thousandGrams = 1000d;
        assertEquals(oneKilogram.toUnit(GM,1d),thousandGrams,0);
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void shouldThrowExceptionForConvertingTwoUnitsOfDifferentTypes() throws IncompatibleUnitTypeException {
        oneKilogram.toUnit(oneLiter,1d);
    }

    @Test
    public void shouldEqualHundredCelsiusToHundredCelsius() throws IncompatibleUnitTypeException {
        double hundredCelsius = CELSIUS.toUnit(CELSIUS, 100d);
        double anotherHundredCelsius = CELSIUS.toUnit(CELSIUS,100d);
        assertThat(hundredCelsius, is(anotherHundredCelsius));
    }

    @Test
    public void shouldEqualHundredCelsiusToTwoHundredTwelveFahrenheit() throws IncompatibleUnitTypeException {
        double hundredCelsius = CELSIUS.toUnit(FAHRENHEIT, 100d);
        double twoHundredTwelveFahrenheit = FAHRENHEIT.toUnit(FAHRENHEIT,212d);
        assertThat(hundredCelsius, is(twoHundredTwelveFahrenheit));
    }

    @Test
    public void shouldEqualsTwoHundredTwelveFahrenheitToHundredCelsius() throws IncompatibleUnitTypeException {
        double twoHundredTwelveFahrenheit = FAHRENHEIT.toUnit(CELSIUS,212d);
        double hundredCelsius = CELSIUS.toUnit(CELSIUS, 100d);
        assertThat(twoHundredTwelveFahrenheit, is(hundredCelsius));
    }
}