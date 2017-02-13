package com.karlkyck.valuetypes_in_java8;

public class InvoiceItem {
    public final String description;
    public final double amount;
    public final double vatAmount;

    public InvoiceItem(String description, double amount, double vatAmount) {
        this.description = description;
        this.amount = amount;
        this.vatAmount = vatAmount;
    }
}
