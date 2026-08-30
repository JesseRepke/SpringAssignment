package edu.wctc.sales.shipping;

import edu.wctc.sales.Sale;

public interface ShippingPolicy {
    void applyShipping(Sale sale);
}