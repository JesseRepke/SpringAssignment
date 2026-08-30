package edu.wctc.sales.report;

import edu.wctc.sales.Sale;

import java.util.List;

public interface SalesReport {
    void generateReport(List<Sale> salesList);
}