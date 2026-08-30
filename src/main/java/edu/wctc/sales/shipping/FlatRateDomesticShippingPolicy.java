package edu.wctc.sales.shipping;

import edu.wctc.sales.Sale;

public class FlatRateDomesticShippingPolicy implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {

        if (sale.getCountry().equalsIgnoreCase("United States")) {
            sale.setShipping(29.95);
        } else {
            sale.setShipping(sale.getAmount() * 0.10);
        }
    }
}