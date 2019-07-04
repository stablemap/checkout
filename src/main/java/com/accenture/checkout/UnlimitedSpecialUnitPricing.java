package com.accenture.checkout;

public class UnlimitedSpecialUnitPricing implements SpecialUnitPricing {

  private int multiple;
  private int price;

  public UnlimitedSpecialUnitPricing(int multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceForUnits(int count, BasicUnitPricing basicUnitPricing) {
    double fraction = count / (double) multiple;
    return (int) Math.ceil(fraction * price);
  }
}
