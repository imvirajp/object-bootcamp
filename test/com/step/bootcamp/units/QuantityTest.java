package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {

    private Quantity hundredCelsius;
    private Quantity twoHundredTwelveFahrenheit;

    @Before
    public void setUp() {
        hundredCelsius = Quantity.inCelsius(100d);
        twoHundredTwelveFahrenheit = Quantity.inFahrenheit(212d);
    }
    @Test
    public void shouldGiveTwoHundredTwelveFahrenheitForHundredCelsius() {
        assertEquals(hundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void shouldGiveThreeHundredNinetyTwoFahrenheitForTwoHundredCelsius() {
        Quantity threeHundredNinetyTwoFahrenheit = Quantity.inFahrenheit(392d);
        Quantity twoHundredCelsius = Quantity.inCelsius(200d);
        assertEquals(twoHundredCelsius,threeHundredNinetyTwoFahrenheit);
    }
}