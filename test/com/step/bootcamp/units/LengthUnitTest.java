package com.step.bootcamp.units;

import org.junit.Test;

import static org.junit.Assert.*;

// Ensures LengthUnit behaves properly

public class LengthUnitTest {

    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        LengthUnit oneFoot = LengthUnit.FEET;
        assertEquals(oneFoot.toInches(1d),12d,0);
    }

    @Test
    public void shouldGiveOneInchForInch() {
        LengthUnit oneInch = LengthUnit.INCH;
        assertEquals(oneInch.toInches(1d),1d,0);
    }

    @Test
    public void shouldGiveTwoInchesForFiveCentimeter() {
        LengthUnit fiveCM = LengthUnit.CM;
        assertEquals(fiveCM.toInches(5d),2d,0);
    }

    @Test
    public void shouldGiveOneInchForThirtyMillimeter() {
        LengthUnit thirtyMM = LengthUnit.MM;
        assertEquals(thirtyMM.toInches(25d),1d,0);
    }
}