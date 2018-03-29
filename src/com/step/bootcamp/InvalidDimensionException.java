package com.step.bootcamp;

public class InvalidDimensionException extends Throwable {
    public InvalidDimensionException() {
        super("Invalid Dimensions : Provide valid dimensions!");
    }
}
