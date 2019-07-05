package com.accenture.checkout;

public class LimitedSpecialUnitPricing implements SpecialUnitPricing {

  private SpecialUnitPricing specialUnitPricing;
  private int unitLimit;

  public LimitedSpecialUnitPricing(SpecialUnitPricing specialUnitPricing, int unitLimit) {
    this.specialUnitPricing = specialUnitPricing;
    this.unitLimit = unitLimit;
  }

  @Override
  public int priceFor(double itemQuantity, LinearItemPricing linearItemPricing) {
    if (itemQuantity > unitLimit) {
      return specialUnitPricing.priceFor(unitLimit, linearItemPricing) + linearItemPricing
          .priceFor(itemQuantity - unitLimit);
    }
    return specialUnitPricing.priceFor(itemQuantity, null);
  }
}
