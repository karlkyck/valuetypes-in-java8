package com.karlkyck.valuetypes_in_java8;

public class Amount {

    public static final Amount ZERO = new Amount(0);

    private final double value;

    public Amount(double value) {
        this.value = value;
    }

    public Amount add(Amount that) {
        return new Amount(value + that.value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
