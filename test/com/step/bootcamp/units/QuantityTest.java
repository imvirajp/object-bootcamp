package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static com.step.bootcamp.units.Unit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuantityTest {

    private Quantity oneFoot;
    private Quantity oneGallon;
    private Quantity oneTonne;
    private Quantity twoInches;
    private Quantity fourInches;
    private Quantity twelveInches;
    private Quantity twentyFourInches;
    private Quantity oneKilogram;
    private Quantity threeInches;
    private Quantity twoPointFiveCM;

    @Before
    public void setUp() {
        oneFoot = Quantity.inFeet(1d);
        oneGallon = Quantity.inGallons(1d);
        oneTonne = Quantity.inTonnes(1d);
        twoInches = Quantity.inInches(2d);
        fourInches = Quantity.inInches(4d);
        twelveInches = Quantity.inInches(12d);
        twentyFourInches = Quantity.inInches(24d);
        oneKilogram = Quantity.inKilograms(1d);
        threeInches = Quantity.inInches(3d);
        twoPointFiveCM = Quantity.inCentimeters(2.5d);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithOneFeet() {
        Quantity expectedFoot = Quantity.inFeet(1d);
        Quantity expectedInches = Quantity.inInches(12d);
        assertEquals(oneFoot, expectedInches);
        assertEquals(oneFoot, expectedFoot);
    }

    @Test
    public void shouldGiveTrueForComparingZeroFeetWithZeroFeet() {
        Quantity zeroFoot = Quantity.inFeet(0d);
        Quantity zeroInch = Quantity.inInches(0d);
        assertEquals(zeroFoot, zeroInch);
    }

    @Test
    public void shouldGiveFalseForComparingOneFeetWithOneInch() {
        Quantity oneInch = Quantity.inInches(1d);
        assertNotEquals(oneFoot, oneInch);
    }

    @Test
    public void shouldGiveTrueForComparingOneFeetWithTwelveInches() {
        Quantity twelveInches = Quantity.inInches(12d);
        assertEquals(oneFoot, twelveInches);
    }

    @Test
    public void shouldGiveTrueForComparingTwoInchWithFiveCentimeter() {
        Quantity twoInches = Quantity.inInches(2);
        Quantity fiveCentimeter = Quantity.inCentimeters(5);
        assertEquals(twoInches,fiveCentimeter);
    }

    @Test
    public void shouldGiveTrueForComparingOneCentimeterWithTenMillimeter() {
        Quantity oneCentimeter = Quantity.inCentimeters(1d);
        Quantity tenMillimeter = Quantity.inMillimeters(10d);
        assertEquals(oneCentimeter,tenMillimeter);
    }

    @Test
    public void shouldGiveTrueFoComparingOneGallonToOneGallon() {
        Quantity anotherGallon = Quantity.inGallons(1d);
        assertEquals(oneGallon,anotherGallon);
    }

    @Test
    public void shouldGiveTrueForComparingOneGallonWithThreePointSevenEightLiters() {
        Quantity threePointSevenEightLiters = Quantity.inLiters(3.78d);
        assertEquals(oneGallon,threePointSevenEightLiters);
    }

    @Test
    public void shouldGiveTrueFoComparingOneTonneToOneTonne() {
        Quantity anotherTonne = Quantity.inTonnes(1d);
        assertEquals(oneTonne,anotherTonne);
    }

    @Test
    public void shouldGiveTrueForComparingOneTonneWithThousandKilograms() {
        Quantity thousandKilograms = Quantity.inKilograms(1000d);
        assertEquals(oneTonne,thousandKilograms);
    }

    @Test
    public void shouldThrowInvalidUnitComparisonExceptionForComparingOneKilogramWithOneInch() {
        Quantity oneInch = Quantity.inInches(1d);
        assertNotEquals(oneInch.hashCode(),oneKilogram.hashCode());
        assertNotEquals(oneInch, oneKilogram);
    }

    @Test
    public void shouldGiveFourInchesForAddingTwoInchAndTwoInch() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity anotherTwoInches = Quantity.inInches(2d);
        assertEquals(twoInches.add(anotherTwoInches), fourInches);
    }

    @Test
    public void shouldNotGiveFourInchesForAddingTwoInchAndFourInch() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity fourKilograms = Quantity.inKilograms(4d);
        Quantity unexpectedAddition = twoInches.add(fourInches);
        assertNotEquals(unexpectedAddition,fourKilograms);
        assertNotEquals(unexpectedAddition.hashCode(), fourKilograms.hashCode());
    }

    @Test
    public void shouldGiveTwoFeetForAddingOneFeetAndTwelveInches() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity expectedAddition = oneFoot.add(twelveInches).toUnit(INCH);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveTwentyFourInchesForAddingTwelveInchesAndOneFeet() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity expectedAddition = twelveInches.add(oneFoot);
        assertEquals(expectedAddition,twentyFourInches);
        assertEquals(expectedAddition.hashCode(), twentyFourInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoInchesAndTwoPointFiveCM() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity expectedAddition = twoInches.add(twoPointFiveCM);
        assertEquals(expectedAddition, threeInches);
        assertEquals(expectedAddition.hashCode(), threeInches.hashCode());
    }

    @Test
    public void shouldGiveThreeInchesForAddingTwoPointFiveCMAndTwoInches() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity expectedAddition = twoPointFiveCM.add(twoInches).toUnit(INCH);
        assertEquals(expectedAddition,threeInches);
        assertEquals(expectedAddition.hashCode(),threeInches.hashCode());
        assertEquals(expectedAddition.toString(),threeInches.toString());
    }

    @Test(expected = IncompatibleUnitTypeException.class)
    public void shouldThrowExceptionForAddingDifferentUnits() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        twoInches.add(oneKilogram);
    }

    @Test
    public void shouldGiveThirteenInchesForAddingOneFootAndTwoPointFiveCM() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity thirteenInches = Quantity.inInches(13d);
        Quantity expectedAddition = oneFoot.add(twoPointFiveCM);
        assertEquals(expectedAddition,thirteenInches);
        assertEquals(expectedAddition.toUnit(INCH).hashCode(),thirteenInches.hashCode());
        assertEquals(expectedAddition.toUnit(INCH).toString(),thirteenInches.toString());
    }

    @Test
    public void shouldReturnFalseForComparingUnitsOfDifferentTypes() {
        assertNotEquals(twoInches,oneKilogram);
    }

    @Test
    public void shouldGiveFourPointSevenEightLitersForAddingOneGallonAndOneLiter() throws IncompatibleUnitTypeException, IncompatibleTypeConversionException {
        Quantity oneLiter = Quantity.inLiters(1d);
        Quantity fourPointSevenEightLiters = Quantity.inLiters(4.78d);
        Quantity expectedAddition = oneGallon.add(oneLiter).toUnit(LITER);
        assertEquals(expectedAddition,fourPointSevenEightLiters);
        assertEquals(expectedAddition.toString(),fourPointSevenEightLiters.toString());
    }
}