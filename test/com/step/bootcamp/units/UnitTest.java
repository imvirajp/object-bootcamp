package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnitTest {

    private Unit oneLiter;
    private Unit oneKilogram;

    @Before
    public void setUp() {
        oneLiter = Unit.LITER;
        oneKilogram = Unit.KG;
    }

    @Test
    public void shouldConvertOneKilogramToThousandGrams() throws IncompatibleTypeConversionException {
        double thousandGrams = 1000d;
        assertEquals(oneKilogram.toUnit(Unit.GM,1d),thousandGrams,0);
    }

    @Test(expected = IncompatibleTypeConversionException.class)
    public void shouldThrowExceptionForConvertingTwoUnitsOfDifferentTypes() throws IncompatibleTypeConversionException {
        oneKilogram.toUnit(oneLiter,1d);
    }
}