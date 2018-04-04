package com.step.bootcamp.units;

public class IncompatibleTypeConversionException extends Throwable {
    public IncompatibleTypeConversionException() {
        super("Can not convert two units of different types!");
    }
}
