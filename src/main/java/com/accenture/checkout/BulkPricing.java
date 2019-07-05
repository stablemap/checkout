package com.accenture.checkout;

import static com.accenture.checkout.Utilities.ceil;

public class BulkPricing implements SpecialPricing {

  private double multiple;
  private int price;

  public BulkPricing(double multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceFor(double quantity, LinearPricing linearPricing) {
    double fraction = quantity / multiple;
    return ceil(fraction * price);
  }
}
