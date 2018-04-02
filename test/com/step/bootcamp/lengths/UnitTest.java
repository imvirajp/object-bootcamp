package com.step.bootcamp.lengths;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitTest {

    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        Unit oneFoot = Unit.FEET;
        assertEquals(oneFoot.toInches(1d),12d,0);
    }

    @Test
    public void shouldGiveOneInchForInch() {
        Unit oneInch = Unit.INCH;
        assertEquals(oneInch.toInches(1d),1d,0);
    }

    @Test
    public void shouldGiveTwoInchesForFiveCentimeters() {
        Unit fiveCm = Unit.CM;
        assertEquals(fiveCm.toInches(5d),2d,0);
    }
}