package com.accenture.checkout;

public class LimitedSpecialUnitPricing implements SpecialUnitPricing {

  private SpecialUnitPricing specialUnitPricing;
  private int unitLimit;

  public LimitedSpecialUnitPricing(SpecialUnitPricing specialUnitPricing, int unitLimit) {
    this.specialUnitPricing = specialUnitPricing;
    this.unitLimit = unitLimit;
  }

  @Override
  public int priceForUnits(int count, BasicUnitPricing basicUnitPricing) {
    return specialUnitPricing.priceForUnits(count, null);
  }
}
