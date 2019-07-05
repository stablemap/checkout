package com.accenture.checkout;

public class RequiredPurchaseSpecialUnitPricing implements SpecialUnitPricing {

  private int requiredUnits;
  private int discountedUnits;
  private int discount;

  public RequiredPurchaseSpecialUnitPricing(int requiredUnits, int discountedUnits, int discount) {
    this.requiredUnits = requiredUnits;
    this.discountedUnits = discountedUnits;
    this.discount = discount;
  }

  @Override
  public int priceForUnits(int count, BasicUnitPricing basicUnitPricing) {
    if (count <= requiredUnits) {
      return basicUnitPricing.priceForUnits(count);
    }
    return 599;
  }
}
