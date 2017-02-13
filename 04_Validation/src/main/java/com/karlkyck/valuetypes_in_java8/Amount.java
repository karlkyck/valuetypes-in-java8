package com.karlkyck.valuetypes_in_java8;

public class Amount {

    public static final Amount ZERO = new Amount(0);

    private final double value;

    private Amount(double value) {
        this.value = value;
    }

    public static Amount of(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        } else {
            return new Amount(value);
        }
    }

    public Amount add(Amount that) {
        return new Amount(value + that.value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
