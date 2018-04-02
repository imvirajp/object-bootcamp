package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Ensures Length behaves correctly

public class LengthTest {

    private Length oneFoot;

    @Before
    public void setUp() {
        oneFoot = Length.inFeet(1d);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithOneFeet() {
        Length expectedFoot = Length.inFeet(1d);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForComparingZeroFeetWithZeroFeet() {
        Length zeroFoot = Length.inFeet(0d);
        Length zeroInch = Length.inInches(0d);
        assertEquals(zeroFoot, zeroInch);
    }

    @Test
    public void shouldGiveFalseForComparingOneFeetWithOneInch() {
        Length oneInch = Length.inInches(1d);
        assertNotEquals(oneFoot, oneInch);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithTwelveInches() {
        Length twelveInches = Length.inInches(12d);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveTrueForComparingTwoInchWithFiveCentimeter() {
        Length twoInches = Length.inInches(2);
        Length fiveCentimeter = Length.inCentimeters(5);
        assertEquals(twoInches,fiveCentimeter);
    }

    @Test
    public void shouldGiveTrueForComparingOneCentimeterWithTenMillimeter() {
        Length oneCentimeter = Length.inCentimeters(1d);
        Length tenMillimeter = Length.inMillimeters(10d);
        assertEquals(oneCentimeter,tenMillimeter);
    }
}