package ru.ifmo.demo.exceptions;


public class ZeroPrecision extends RuntimeException {
    @Override
    public String getMessage() {
        return "Precision can not be zero";
    }
}
