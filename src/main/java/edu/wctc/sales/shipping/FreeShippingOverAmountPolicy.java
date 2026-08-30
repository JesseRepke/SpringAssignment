package edu.wctc.sales.shipping;

import edu.wctc.sales.Sale;

public class FreeShippingOverAmountPolicy implements ShippingPolicy {

    private double minimumAmount;
    private double shippingRate;

    public FreeShippingOverAmountPolicy(double minimumAmount, double shippingRate) {
        this.minimumAmount = minimumAmount;
        this.shippingRate = shippingRate;
    }

    @Override
    public void applyShipping(Sale sale) {

        if (sale.getAmount() >= minimumAmount) {
            sale.setShipping(0.00);
        } else {
            sale.setShipping(sale.getAmount() * shippingRate);
        }
    }
}