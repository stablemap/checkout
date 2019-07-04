package com.accenture.checkout;

public class ByMultipleUnitPricing implements UnitPricing {

  private int multiple;
  private int price;

  public ByMultipleUnitPricing(int multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceForUnits(int count, int leftOverPerUnitPrice) {
    double fraction = count / (double) multiple;
    return (int) Math.ceil(fraction * price);
  }
}
