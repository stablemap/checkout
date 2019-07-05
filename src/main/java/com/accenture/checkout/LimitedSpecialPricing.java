package com.accenture.checkout;

public class LimitedSpecialPricing implements SpecialPricing {

  private SpecialPricing specialPricing;
  private int unitLimit;

  public LimitedSpecialPricing(SpecialPricing specialPricing, int unitLimit) {
    this.specialPricing = specialPricing;
    this.unitLimit = unitLimit;
  }

  @Override
  public int priceFor(double itemQuantity, LinearItemPricing linearItemPricing) {
    if (itemQuantity > unitLimit) {
      return specialPricing.priceFor(unitLimit, linearItemPricing) + linearItemPricing
          .priceFor(itemQuantity - unitLimit);
    }
    return specialPricing.priceFor(itemQuantity, null);
  }
}
