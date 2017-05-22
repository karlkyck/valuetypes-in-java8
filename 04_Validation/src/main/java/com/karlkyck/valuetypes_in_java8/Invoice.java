package com.karlkyck.valuetypes_in_java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invoice {

    public static void main(String[] args) {
        InvoiceItem hardWork = new InvoiceItem(
                "Hard work!",
                Amount.of(40.1),
                VatAmount.of(5.0125)
        );
        InvoiceItem evenHarderWork = new InvoiceItem(
                "Even Harder work!",
                Amount.of(60.2),
                VatAmount.of(10.535)
        );
        InvoiceItem superHardWork = new InvoiceItem(
                "Super Harder work!",
                Amount.of(100.3),
                VatAmount.of(23.069)
        );

        List<InvoiceItem> invoiceItems = Collections.unmodifiableList(
                Arrays.asList(
                        hardWork,
                        evenHarderWork,
                        superHardWork
                ));

        Amount totalAmount = invoiceItems
                .stream()
                .reduce(
                        Amount.ZERO,
                        (amount, invoiceItem) -> amount.add(invoiceItem.amount),
                        Amount::add
                );

        VatAmount totalVatAmount = invoiceItems
                .stream()
                .reduce(
                        VatAmount.ZERO,
                        (amount, invoiceItem) -> amount.add(invoiceItem.vatAmount),
                        VatAmount::add
                );

        System.out.println(String.format("Total invoice amount is %s", totalAmount));
        System.out.println(String.format("Total invoice vat amount is %s", totalVatAmount));
    }
}
