package com.karlkyck.valuetypes_in_java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invoice {

    public static void main(String[] args) {
        InvoiceItem hardWork = new InvoiceItem("Hard work!", new Amount(40.1), new VatAmount(5.0125));
        InvoiceItem evenHarderWork = new InvoiceItem("Even Harder work!", new Amount(60.2), new VatAmount(10.535));
        InvoiceItem superHardWork = new InvoiceItem("Super Harder work!", new Amount(100.3), new VatAmount(23.069));

        List<InvoiceItem> invoiceItems = Collections.unmodifiableList(Arrays.asList(
                hardWork,
                evenHarderWork,
                superHardWork));

        double totalAmount = invoiceItems.stream().mapToDouble(item -> item.vatAmount.value).sum();
        double totalVatAmount = invoiceItems.stream().mapToDouble(item -> item.amount.value).sum();

        System.out.println(String.format("Total invoice amount is %s", totalAmount));
        System.out.println(String.format("Total invoice vat amount is %s", totalVatAmount));
    }
}
