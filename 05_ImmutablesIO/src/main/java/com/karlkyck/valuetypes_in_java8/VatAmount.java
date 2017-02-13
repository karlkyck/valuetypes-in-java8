package com.karlkyck.valuetypes_in_java8;

import org.immutables.value.Value;

@Value.Immutable
@Value.Style(visibility = Value.Style.ImplementationVisibility.PACKAGE)
public abstract class VatAmount {

    @Value.Parameter
    abstract double value();

    public static VatAmount of(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("VatAmount must be greater than 0");
        } else {
            return ImmutableVatAmount.of(value);
        }
    }

    public static VatAmount zero() {
        return ImmutableVatAmount.of(0);
    }

    public VatAmount add(VatAmount that) {
        return VatAmount.of(value() + that.value());
    }

    @Override
    public String toString() {
        return Double.toString(value());
    }
}
