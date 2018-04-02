package com.step.bootcamp.units;

import java.util.Objects;

// Understands to represent comparison of given volumes

public class Volume {
    private final double value;
    private final VolumeUnit unit;

    private Volume(double value, VolumeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Volume inGallons(double value) {
        return new Volume(value, VolumeUnit.GALLON);
    }

    public static Volume inLiters(double value) {
        return new Volume(value,VolumeUnit.LITER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return Double.compare(volume.unit.toLiters(volume.value),
                this.unit.toLiters(this.value))==0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, unit);
    }
}
