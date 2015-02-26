package ru.ifmo.demo.exceptions;

public class InvalidPrecision extends RuntimeException {
    @Override
    public String getMessage() {
        return "Invalid precision value";
    }
}
