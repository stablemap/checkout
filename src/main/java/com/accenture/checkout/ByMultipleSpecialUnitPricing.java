package com.accenture.checkout;

public class ByMultipleSpecialUnitPricing implements SpecialUnitPricing {

  private int multiple;
  private int price;

  public ByMultipleSpecialUnitPricing(int multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceForUnits(int count) {
    double fraction = count / (double) multiple;
    return (int) Math.ceil(fraction * price);
  }
}
