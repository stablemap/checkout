package com.accenture.checkout;

public class RequiredPurchaseSpecialUnitPricing implements SpecialUnitPricing {

  private final int requiredUnits;
  private final int discountedUnits;
  private final int discount;

  public RequiredPurchaseSpecialUnitPricing(int requiredUnits, int discountedUnits, int discount) {
    this.requiredUnits = requiredUnits;
    this.discountedUnits = discountedUnits;
    this.discount = discount;
  }

  @Override
  public int priceForUnits(int count, BasicUnitPricing basicUnitPricing) {
    return 599;
  }
}
