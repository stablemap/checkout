package com.accenture.checkout;

public class LimitedSpecialUnitPricing implements SpecialUnitPricing {

  private SpecialUnitPricing specialUnitPricing;
  private int unitLimit;

  public LimitedSpecialUnitPricing(SpecialUnitPricing specialUnitPricing, int unitLimit) {
    this.specialUnitPricing = specialUnitPricing;
    this.unitLimit = unitLimit;
  }

  @Override
  public int priceForUnits(int count, LinearItemPricing linearItemPricing) {
    if (count > unitLimit) {
      return specialUnitPricing.priceForUnits(unitLimit, linearItemPricing) + linearItemPricing
          .priceFor(count - unitLimit);
    }
    return specialUnitPricing.priceForUnits(count, null);
  }
}
