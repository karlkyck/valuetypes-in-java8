package com.karlkyck.valuetypes_in_java8;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
public abstract class Amount {

    @Value.Parameter
    abstract double value();

    public static Amount of(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        } else {
            return ImmutableAmount.of(value);
        }
    }

    public static Amount zero() {
        return ImmutableAmount.of(0);
    }

    public Amount add(Amount that) {
        return Amount.of(value() + that.value());
    }

    @Override
    public String toString() {
        return Double.toString(value());
    }
}
