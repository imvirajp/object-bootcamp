package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static com.step.bootcamp.units.Unit.*;
import static org.junit.Assert.*;

public class ArithmeticMeasurementTest {

    private ArithmeticMeasurement oneFoot;
    private ArithmeticMeasurement oneGallon;
    private ArithmeticMeasurement oneTonne;
    private ArithmeticMeasurement twoInches;
    private ArithmeticMeasurement fourInches;
    private ArithmeticMeasurement twelveInches;
    private ArithmeticMeasurement twentyFourInches;
    private ArithmeticMeasurement oneKilogram;
    private ArithmeticMeasurement threeInches;
    private ArithmeticMeasurement twoPointFiveCM;

    @Before
    public void setUp() {
        oneFoot = ArithmeticMeasurement.inFeet(1d);
        oneGallon = ArithmeticMeasurement.inGallons(1d);
        oneTonne = ArithmeticMeasurement.inTonnes(1d);
        twoInches = ArithmeticMeasurement.inInches(2d);
        fourInches = ArithmeticMeasurement.inInches(4d);
        twelveInches = ArithmeticMeasurement.inInches(12d);
        twentyFourInches = ArithmeticMeasurement.inInches(24d);
        oneKilogram = ArithmeticMeasurement.inKilograms(1d);
        threeInches = ArithmeticMeasurement.inInches(3d);
        twoPointFiveCM = ArithmeticMeasurement.inCentimeters(2.5d);
    }


    @Test
    public void shouldGiveTrueForComparingOneFeetWithOneFeet() {
        ArithmeticMeasurement expectedFoot = ArithmeticMeasurement.inFeet(1d);
        ArithmeticMeasurement expectedInches = ArithmeticMeasurement.inInches(12d);
        assertEquals(oneFoot, expectedInches);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForComparingZeroFeetWithZeroFeet() {
        ArithmeticMeasurement zeroFoot = ArithmeticMeasurement.inFeet(0d);
        ArithmeticMeasurement zeroInch = ArithmeticMeasurement.inInches(0d);
        assertEquals(zeroFoot, zeroInch);
    }

    @Test
    public void shouldGiveFalseForComparingOneFeetWithOneInch() {
        ArithmeticMeasurement oneInch = ArithmeticMeasurement.inInches(1d);
        assertNotEquals(oneFoot, oneInch);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithTwelveInches() {
        ArithmeticMeasurement twelveInches = ArithmeticMeasurement.inInches(12d);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveTrueForComparingTwoInchWithFiveCentimeter() {
        ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2);
        ArithmeticMeasurement fiveCentimeter = ArithmeticMeasurement.inCentimeters(5);
        assertEquals(twoInches,fiveCentimeter);
    }

    @Test
    public void shouldGiveTrueForComparingOneCentimeterWithTenMillimeter() {
        ArithmeticMeasurement oneCentimeter = ArithmeticMeasurement.inCentimeters(1d);
        ArithmeticMeasurement tenMillimeter = ArithmeticMeasurement.inMillimeters(10d);
        assertEquals(oneCentimeter,tenMillimeter);
    }

    @Test
    public void shouldGiveTrueFoComparingOneGallonToOneGallon() {
        ArithmeticMeasurement anotherGallon = ArithmeticMeasurement.inGallons(1d);
        assertEquals(oneGallon,anotherGallon);
    }

    @Test
    public void shouldGiveTrueForComparingOneGallonWithThreePointSevenEightLiters() {
        ArithmeticMeasurement threePointSevenEightLiters = ArithmeticMeasurement.inLiters(3.78d);
        assertEquals(oneGallon,threePointSevenEightLiters);
    }

    @Test
    public void shouldGiveTrueFoComparingOneTonneToOneTonne() {
        ArithmeticMeasurement anotherTonne = ArithmeticMeasurement.inTonnes(1d);
        assertEquals(oneTonne,anotherTonne);
    }

    @Test
    public void shouldGiveTrueForComparingOneTonneWithThousandKilograms() {
        ArithmeticMeasurement thousandKilograms = ArithmeticMeasurement.inKilograms(1000d);
        assertEquals(oneTonne,thousandKilograms);
    }

    @Test
    public void shouldThrowInvalidUnitComparisonExceptionForComparingOneKilogramWithOneInch() {
        ArithmeticMeasurement oneInch = ArithmeticMeasurement.inInches(1d);
        assertNotEquals(oneInch.hashCode(),oneKilogram.hashCode());
        assertNotEquals(oneInch, oneKilogram);
    }

    @Test
    public void shouldGiveFourInchesForAddingTwoInchAndTwoInch() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement anotherTwoInches = ArithmeticMeasurement.inInches(2d);
        assertEquals(twoInches.add(anotherTwoInches), fourInches);
    }

    @Test
    public void shouldNotGiveFourInchesForAddingTwoInchAndFourInch() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement fourKilograms = ArithmeticMeasurement.inKilograms(4d);
        ArithmeticMeasurement unexpectedAddition = twoInches.add(fourInches);
        assertNotEquals(unexpectedAddition,fourKilograms);
        assertNotEquals(unexpectedAddition.hashCode(), fourKilograms.hashCode());
    }

    @Test
    public void shouldGiveTwoFeetForAddingOneFeetAndTwelveInches() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = oneFoot.add(twelveInches).toUnit(INCH);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveTwentyFourInchesForAddingTwelveInchesAndOneFeet() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twelveInches.add(oneFoot);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoInchesAndTwoPointFiveCM() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twoInches.add(twoPointFiveCM);
        assertEquals(expectedAddition, threeInches);
        assertEquals(expectedAddition.hashCode(), threeInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoPointFiveCMAndTwoInches() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement expectedAddition = twoPointFiveCM.add(twoInches).toUnit(INCH);
        assertEquals(expectedAddition,threeInches);
        assertEquals(expectedAddition.hashCode(),threeInches.hashCode());
        assertEquals(expectedAddition.toString(),threeInches.toString());
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void shouldThrowExceptionForAddingDifferentUnits() throws IncompatibleUnitTypeException {
        twoInches.add(oneKilogram);
    }

    @Test
    public void shouldGiveThirteenInchesForAddingOneFootAndTwoPointFiveCM() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement thirteenInches = ArithmeticMeasurement.inInches(13d);
        ArithmeticMeasurement expectedAddition = oneFoot.add(twoPointFiveCM);
        assertEquals(expectedAddition,thirteenInches);
        assertEquals(expectedAddition.toUnit(INCH).hashCode(),thirteenInches.hashCode());
        assertEquals(expectedAddition.toUnit(INCH).toString(),thirteenInches.toString());
    }

    @Test
    public void shouldReturnFalseForComparingUnitsOfDifferentTypes() {
        assertNotEquals(twoInches,oneKilogram);
    }

    @Test
    public void shouldGiveFourPointSevenEightLitersForAddingOneGallonAndOneLiter() throws IncompatibleUnitTypeException {
        ArithmeticMeasurement oneLiter = ArithmeticMeasurement.inLiters(1d);
        ArithmeticMeasurement fourPointSevenEightLiters = ArithmeticMeasurement.inLiters(4.78d);
        ArithmeticMeasurement expectedAddition = oneGallon.add(oneLiter).toUnit(LITER);
        assertEquals(expectedAddition,fourPointSevenEightLiters);
        assertEquals(expectedAddition.toString(),fourPointSevenEightLiters.toString());
    }
}