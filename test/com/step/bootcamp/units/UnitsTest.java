package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnitsTest {

    private Units oneLiter;
    private Units oneGallon;
    private Units oneKilogram;
    private Units oneTonne;

    @Before
    public void setUp() {
        oneLiter = Units.LITER;
        oneGallon = Units.GALLON;
        oneKilogram = Units.KG;
        oneTonne = Units.TON;
    }

    @Test
    public void shouldGiveTwelveInchesForOneFoot() {
        Units oneFoot = Units.FEET;
        assertEquals(oneFoot.toBaseUnit(1d), 12d, 0);
    }

    @Test
    public void shouldGiveOneInchForInch() {
        Units oneInch = Units.INCH;
        assertEquals(oneInch.toBaseUnit(1d), 1d, 0);
    }

    @Test
    public void shouldGiveTwoInchesForFiveCentimeter() {
        Units fiveCM = Units.CM;
        assertEquals(fiveCM.toBaseUnit(5d), 2d, 0);
    }

    @Test
    public void shouldGiveOneInchForThirtyMillimeter() {
        Units thirtyMM = Units.MM;
        assertEquals(thirtyMM.toBaseUnit(25d), 1d, 0);
    }

    @Test
    public void shouldGiveThreePointSevenEightLitersForOneGallon() {
        assertEquals(oneGallon.toBaseUnit(1d), 3.78d, 0);
    }

    @Test
    public void shouldGiveOneLiterForOneLiter() {
        assertEquals(oneLiter.toBaseUnit(1d), 1d, 0);
    }

    @Test
    public void shouldNotGiveOneLiterForOneGallon() {
        assertNotEquals(oneGallon.toBaseUnit(1d), 1d, 0);
    }

    @Test
    public void shouldGiveOneKilogramForOneKilogram() {
        assertEquals(oneKilogram.toBaseUnit(1d), 1d, 0);
    }

    @Test
    public void shouldGiveOneKilogramForOneTonne() {
        assertEquals(oneTonne.toBaseUnit(1d), 1000d, 0);
    }

    @Test
    public void shouldNotGiveOneKilogramForOneTonne() {
        assertNotEquals(oneTonne.toBaseUnit(1d), 1d, 0);
    }
}