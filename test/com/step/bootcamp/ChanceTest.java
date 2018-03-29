package com.step.bootcamp;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

// Ensures that chance of given occurrence is correct.
public class ChanceTest {

    private Chance chance;

    @Before
    public void setUp() {
        chance = new Chance(0.5);
    }

    @Test
    public void chanceOfNotGettingTailWhenCoinIsFlipped() {
        assertThat(chance.not(),is(new Chance(0.5)));
    }
}