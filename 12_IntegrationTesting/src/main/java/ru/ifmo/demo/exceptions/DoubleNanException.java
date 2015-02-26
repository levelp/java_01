package ru.ifmo.demo.exceptions;


public class DoubleNanException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Precision is too low or X is too high";
    }
}
