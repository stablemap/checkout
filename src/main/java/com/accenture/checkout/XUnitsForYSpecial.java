package com.accenture.checkout;

public class XUnitsForYSpecial implements UnitPricing {

  private int count;
  private int price;

  public XUnitsForYSpecial(int count, int price) {
    this.count = count;
    this.price = price;
  }

  @Override
  public int priceForUnits(int count) {
    double fraction = count / (double) this.count;
    return (int) Math.ceil(fraction * price);
  }
}
