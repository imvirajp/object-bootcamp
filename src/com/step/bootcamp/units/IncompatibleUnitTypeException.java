package com.step.bootcamp.units;

public class IncompatibleUnitTypeException extends Throwable {
    public IncompatibleUnitTypeException() {
        super("Can not add units of different types!");
    }
}
