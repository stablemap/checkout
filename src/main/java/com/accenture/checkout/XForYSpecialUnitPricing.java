package com.accenture.checkout;

public class XForYSpecialUnitPricing implements SpecialUnitPricing {

  private double multiple;
  private int price;

  public XForYSpecialUnitPricing(double multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceFor(double count, LinearItemPricing linearItemPricing) {
    double fraction = count / multiple;
    return (int) Math.ceil(fraction * price);
  }
}
