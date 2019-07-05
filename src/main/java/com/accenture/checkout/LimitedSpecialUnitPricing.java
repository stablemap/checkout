package com.accenture.checkout;

public class LimitedSpecialUnitPricing implements SpecialUnitPricing {

  private SpecialUnitPricing specialUnitPricing;
  private int unitLimit;

  public LimitedSpecialUnitPricing(SpecialUnitPricing specialUnitPricing, int unitLimit) {
    this.specialUnitPricing = specialUnitPricing;
    this.unitLimit = unitLimit;
  }

  @Override
  public int priceForUnits(int count, FractionalItemPricing fractionalItemPricing) {
    if (count > unitLimit) {
      return specialUnitPricing.priceForUnits(unitLimit, fractionalItemPricing) + fractionalItemPricing
          .priceFor(count - unitLimit);
    }
    return specialUnitPricing.priceForUnits(count, null);
  }
}
