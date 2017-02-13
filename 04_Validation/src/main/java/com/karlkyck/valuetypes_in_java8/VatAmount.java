package com.karlkyck.valuetypes_in_java8;

public class VatAmount {

    public static final VatAmount ZERO = new VatAmount(0);

    private final double value;

    private VatAmount(double value) {
        this.value = value;
    }

    public static VatAmount of(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("VatAmount must be greater than 0");
        } else {
            return new VatAmount(value);
        }
    }

    public VatAmount add(VatAmount that) {
        return new VatAmount(value + that.value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
