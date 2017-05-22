package com.karlkyck.valuetypes_in_java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invoice {

    public static void main(String[] args) {

        InvoiceItem hardWork = new InvoiceItem(
                "Hard work!",
                40.1,
                5.0125
        );
        InvoiceItem evenHarderWork = new InvoiceItem(
                "Even Harder work!",
                60.2,
                10.535
        );
        InvoiceItem superHardWork = new InvoiceItem(
                "Super Harder work!",
                100.3,
                23.069
        );

        List<InvoiceItem> invoiceItems = Collections.unmodifiableList(
                Arrays.asList(
                        hardWork,
                        evenHarderWork,
                        superHardWork
                ));

        double totalAmount = invoiceItems
                .stream()
                .mapToDouble(value -> value.vatAmount)
                .sum();

        double totalVatAmount = invoiceItems
                .stream()
                .mapToDouble(value -> value.amount)
                .sum();

        System.out.println(String.format("Total invoice amount is %s", totalAmount));
        System.out.println(String.format("Total invoice vat amount is %s", totalVatAmount));
    }
}
