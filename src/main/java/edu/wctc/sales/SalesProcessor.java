package edu.wctc.sales;

import edu.wctc.sales.input.SalesInput;
import edu.wctc.sales.report.SalesReport;
import edu.wctc.sales.shipping.ShippingPolicy;

import java.util.List;

public class SalesProcessor {

    private SalesInput salesInput;
    private ShippingPolicy shippingPolicy;
    private SalesReport salesReport;

    public SalesProcessor(
            SalesInput salesInput,
            ShippingPolicy shippingPolicy,
            SalesReport salesReport) {

        this.salesInput = salesInput;
        this.shippingPolicy = shippingPolicy;
        this.salesReport = salesReport;
    }

    public void generateReport() {

        List<Sale> allSales = salesInput.getSales();

        for (Sale sale : allSales) {
            shippingPolicy.applyShipping(sale);
        }

        salesReport.generateReport(allSales);
    }
}