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
  public int priceForUnits(int count, FractionalItemPricing fractionalItemPricing) {
    int numBlocks = (int) Math.ceil(count / (double) (requiredUnits + discountedUnits));
    int numDiscounted = count - numBlocks * requiredUnits;

    return fractionalItemPricing.priceFor(count - numDiscounted) + (int) Math.ceil((discount / 100.0) * fractionalItemPricing
        .priceFor(numDiscounted));
  }
}
