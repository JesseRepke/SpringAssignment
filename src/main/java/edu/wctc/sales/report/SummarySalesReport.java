package edu.wctc.sales.report;

import edu.wctc.sales.Sale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SummarySalesReport implements SalesReport {

    @Override
    public void generateReport(List<Sale> salesList) {

        Map<String, double[]> summary = new HashMap<>();

        for (Sale sale : salesList) {

            summary.putIfAbsent(
                    sale.getCountry(),
                    new double[]{0.0, 0.0, 0.0}
            );

            double[] totals = summary.get(sale.getCountry());

            totals[0] += sale.getAmount();
            totals[1] += sale.getTax();
            totals[2] += sale.getShipping();
        }

        System.out.println("SALES SUMMARY REPORT");

        System.out.printf(
                "%-20s %10s %10s %10s%n",
                "Country",
                "Amount",
                "Tax",
                "Shipping"
        );

        for (Map.Entry<String, double[]> entry : summary.entrySet()) {

            double[] totals = entry.getValue();

            System.out.printf(
                    "%-20s %10.2f %10.2f %10.2f%n",
                    entry.getKey(),
                    totals[0],
                    totals[1],
                    totals[2]
            );
        }
    }
}