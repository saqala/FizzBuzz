package com.leboncoin.fizzbuzz.domain.exception;

public class FizzBuzzException extends RuntimeException {

    public static final String PARAM_NULL_OR_LESS_THAN_ONE = "the param %d is null or less than one";
    public static final String STRING_NULL_OR_EMPTY = "the injected string is null or empty";
    public static final String NULL_OBJECT = "fizzbuzz must not be null";

    public FizzBuzzException(String message) {
        super(message);
    }

    public static FizzBuzzException create(String message) {
        return new FizzBuzzException(message);
    }


}
