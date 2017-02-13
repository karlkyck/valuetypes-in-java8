package com.karlkyck.valuetypes_in_java8;

public class InvoiceItem {

    public final String description;
    public final Amount amount;
    public final VatAmount vatAmount;

    public InvoiceItem(String description, Amount amount, VatAmount vatAmount) {
        this.description = description;
        this.amount = amount;
        this.vatAmount = vatAmount;
    }
}
