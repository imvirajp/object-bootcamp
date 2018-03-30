package com.step.bootcamp.rectangle;

public class InvalidDimensionException extends Throwable {
    public InvalidDimensionException() {
        super("Invalid Dimensions : Provide valid dimensions!");
    }
}
