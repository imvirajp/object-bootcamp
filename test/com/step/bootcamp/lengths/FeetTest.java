package com.step.bootcamp.lengths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Ensures that feet behaves correctly
public class FeetTest {

    private Feet feet;

    @Before
    public void setUp() throws Exception {
        feet = new Feet(1d);
    }

    @Test
    public void shouldGiveOneFeetForOneFeet() {
        assertEquals(feet.inFeet(),new Feet(1d));
    }
}
