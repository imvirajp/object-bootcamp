package com.step.bootcamp.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VolumeTest {

    private Volume oneGallon;

    @Before
    public void setUp() {
        oneGallon = Volume.inGallons(1d);
    }

    @Test
    public void shouldGiveTrueFoComparingOneGallonToOneGallon() {
        Volume anotherGallon = Volume.inGallons(1d);
        assertEquals(oneGallon,anotherGallon);
    }

    @Test
    public void shouldGiveTrueForComparingOneGallonWithThreePointSevenEightLiters() {
        Volume threePointSevenEightLiters = Volume.inLiters(3.78d);
        assertEquals(oneGallon,threePointSevenEightLiters);
    }
}
