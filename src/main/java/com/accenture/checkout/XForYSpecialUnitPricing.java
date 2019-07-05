package com.accenture.checkout;

public class XForYSpecialUnitPricing implements SpecialUnitPricing {

  private int multiple;
  private int price;

  public XForYSpecialUnitPricing(int multiple, int price) {
    this.multiple = multiple;
    this.price = price;
  }

  @Override
  public int priceForUnits(int count, FractionalItemPricing fractionalItemPricing) {
    double fraction = count / (double) multiple;
    return (int) Math.ceil(fraction * price);
  }
}
