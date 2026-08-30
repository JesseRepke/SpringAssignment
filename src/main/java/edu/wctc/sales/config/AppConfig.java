package edu.wctc.sales.config;

import edu.wctc.sales.SalesProcessor;
import edu.wctc.sales.input.FileSalesInput;
import edu.wctc.sales.input.SalesInput;
import edu.wctc.sales.report.DetailSalesReport;
import edu.wctc.sales.report.SalesReport;
import edu.wctc.sales.shipping.FlatRateDomesticShippingPolicy;
import edu.wctc.sales.shipping.ShippingPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SalesInput salesInput() {
        return new FileSalesInput("sales.txt");
    }

    @Bean
    public ShippingPolicy shippingPolicy() {
        return new FlatRateDomesticShippingPolicy();
    }

    @Bean
    public SalesReport salesReport() {
        return new DetailSalesReport();
    }

    @Bean
    public SalesProcessor salesProcessor(
            SalesInput salesInput,
            ShippingPolicy shippingPolicy,
            SalesReport salesReport) {

        return new SalesProcessor(
                salesInput,
                shippingPolicy,
                salesReport
        );
    }
}