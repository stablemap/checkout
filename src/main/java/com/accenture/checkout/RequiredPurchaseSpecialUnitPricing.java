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
  public int priceForUnits(int count, LinearItemPricing linearItemPricing) {
    double blockSize = requiredUnits + discountedUnits;
    int completeBlocks = (int) Math.floor(count / blockSize);
    double incompleteBlock = count - completeBlocks * blockSize;

    double withNormalPricing = completeBlocks * requiredUnits + Math.min(blockSize, incompleteBlock);
    double numDiscounted = count - withNormalPricing;

    return linearItemPricing.priceFor(withNormalPricing) + (int) Math.ceil(((100.0 - discount) / 100.0) * linearItemPricing
        .priceFor(numDiscounted));
  }
}
