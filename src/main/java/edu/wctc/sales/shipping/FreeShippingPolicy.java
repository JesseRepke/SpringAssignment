package edu.wctc.sales.shipping;

import edu.wctc.sales.Sale;

public class FreeShippingPolicy implements ShippingPolicy {

    @Override
    public void applyShipping(Sale sale) {
        sale.setShipping(0.00);
    }
}