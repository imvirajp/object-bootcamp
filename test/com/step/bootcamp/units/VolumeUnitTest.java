package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VolumeUnitTest {

    private VolumeUnit oneGallon;
    private VolumeUnit oneLiter;

    @Before
    public void setUp() {
        oneGallon = VolumeUnit.GALLON;
        oneLiter = VolumeUnit.LITER;
    }

    @Test
    public void shouldGiveThreePointSevenEightLitersForOneGallon() {
        assertEquals(oneGallon.toLiters(1d),3.78d,0);
    }

    @Test
    public void shouldGiveOneLiterForOneLiter() {
        assertEquals(oneLiter.toLiters(1d),1d,0);
    }

    @Test
    public void shouldNotGiveOneLiterForOneGallon() {
        assertNotEquals(oneGallon.toLiters(1d),1d,0);
    }
}