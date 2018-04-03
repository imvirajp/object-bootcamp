package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MeasurementsTest {

    private Measurements oneFoot;
    private Measurements oneGallon;
    private Measurements oneTonne;
    private Measurements twoInches;
    private Measurements fourInches;
    private Measurements twelveInches;
    private Measurements twentyFourInches;
    private Measurements oneKilogram;

    @Before
    public void setUp() {
        oneFoot = Measurements.inFeet(1d);
        oneGallon = Measurements.inGallons(1d);
        oneTonne = Measurements.inTonnes(1d);
        twoInches = Measurements.inInches(2d);
        fourInches = Measurements.inInches(4d);
        twelveInches = Measurements.inInches(12d);
        twentyFourInches = Measurements.inInches(24d);
        oneKilogram = Measurements.inKilograms(1d);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithOneFeet() {
        Measurements expectedFoot = Measurements.inFeet(1d);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForComparingZeroFeetWithZeroFeet() {
        Measurements zeroFoot = Measurements.inFeet(0d);
        Measurements zeroInch = Measurements.inInches(0d);
        assertEquals(zeroFoot, zeroInch);
    }

    @Test
    public void shouldGiveFalseForComparingOneFeetWithOneInch() {
        Measurements oneInch = Measurements.inInches(1d);
        assertNotEquals(oneFoot, oneInch);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithTwelveInches() {
        Measurements twelveInches = Measurements.inInches(12d);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveTrueForComparingTwoInchWithFiveCentimeter() {
        Measurements twoInches = Measurements.inInches(2);
        Measurements fiveCentimeter = Measurements.inCentimeters(5);
        assertEquals(twoInches,fiveCentimeter);
    }

    @Test
    public void shouldGiveTrueForComparingOneCentimeterWithTenMillimeter() {
        Measurements oneCentimeter = Measurements.inCentimeters(1d);
        Measurements tenMillimeter = Measurements.inMillimeters(10d);
        assertEquals(oneCentimeter,tenMillimeter);
    }

    @Test
    public void shouldGiveTrueFoComparingOneGallonToOneGallon() {
        Measurements anotherGallon = Measurements.inGallons(1d);
        assertEquals(oneGallon,anotherGallon);
    }

    @Test
    public void shouldGiveTrueForComparingOneGallonWithThreePointSevenEightLiters() {
        Measurements threePointSevenEightLiters = Measurements.inLiters(3.78d);
        assertEquals(oneGallon,threePointSevenEightLiters);
    }

    @Test
    public void shouldGiveTrueFoComparingOneTonneToOneTonne() {
        Measurements anotherTonne = Measurements.inTonnes(1d);
        assertEquals(oneTonne,anotherTonne);
    }

    @Test
    public void shouldGiveTrueForComparingOneTonneWithThousandKilograms() {
        Measurements thousandKilograms = Measurements.inKilograms(1000d);
        assertEquals(oneTonne,thousandKilograms);
    }

    @Test
    public void shouldThrowInvalidUnitComparisonExceptionForComparingOneKilogramWithOneInch() {
        Measurements oneInch = Measurements.inInches(1d);
        assertNotEquals(oneInch.hashCode(),oneKilogram.hashCode());
        assertNotEquals(oneInch, oneKilogram);
    }

    @Test
    public void shouldGiveFourInchesForAddingTwoInchAndTwoInch() throws IncompatibleUnitTypeException {
        Measurements anotherTwoInches = Measurements.inInches(2d);
        assertEquals(twoInches.add(anotherTwoInches), fourInches);
    }

    @Test
    public void shouldNotGiveFourInchesForAddingTwoInchAndFourInch() throws IncompatibleUnitTypeException {
        Measurements anotherFourInches = Measurements.inInches(4d);
        Measurements unexpectedAddition = twoInches.add(fourInches);
        assertNotEquals(unexpectedAddition.hashCode(), anotherFourInches.hashCode());
        assertNotEquals(unexpectedAddition,anotherFourInches);
    }

    @Test
    public void shouldGiveTwoFeetForAddingOneFeetAndTwelveInches() throws IncompatibleUnitTypeException {
        Measurements twoFeet = Measurements.inFeet(2d);
        Measurements expectedAddition = oneFoot.add(twelveInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
        assertEquals(expectedAddition,twoFeet);
    }

    @Test
    public void shouldGiveTwentyFourInchesForAddingTwelveInchesAndOneFeet() throws IncompatibleUnitTypeException {
        Measurements expectedAddition = twelveInches.add(oneFoot);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
        assertEquals(expectedAddition,twentyFourInches);
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void shouldThrowExceptionForAddingDifferentUnits() throws IncompatibleUnitTypeException {
        twoInches.add(oneKilogram);
    }
}