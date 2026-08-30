package edu.wctc.sales.report;

import edu.wctc.sales.Sale;

import java.util.List;

public class DetailSalesReport implements SalesReport {

    @Override
    public void generateReport(List<Sale> salesList) {

        System.out.println("SALES DETAIL REPORT");

        System.out.printf(
                "%-30s %-20s %10s %10s %10s%n",
                "Customer",
                "Country",
                "Amount",
                "Tax",
                "Shipping"
        );

        for (Sale sale : salesList) {

            System.out.printf(
                    "%-30s %-20s %10.2f %10.2f %10.2f%n",
                    sale.getCustomer(),
                    sale.getCountry(),
                    sale.getAmount(),
                    sale.getTax(),
                    sale.getShipping()
            );
        }
    }
}