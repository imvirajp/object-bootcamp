package com.step.bootcamp;

import java.util.Objects;

// Understands to return probability of getting given occurrence.
public class Chance {
    private final double chanceOfOccurrence;

    public Chance(double probability) {
        this.chanceOfOccurrence = probability;
    }

    public Chance not() {
        return new Chance(1-chanceOfOccurrence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.chanceOfOccurrence, chanceOfOccurrence) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chanceOfOccurrence);
    }
}