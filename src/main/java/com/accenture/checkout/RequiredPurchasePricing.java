package com.accenture.checkout;

import static com.accenture.checkout.Utilities.ceil;

public class RequiredPurchasePricing implements SpecialPricing {

  private double requiredQuantity;
  private double discountedQuantity;
  private int discount;

  public RequiredPurchasePricing(double requiredQuantity, double discountedQuantity, int discount) {
    this.requiredQuantity = requiredQuantity;
    this.discountedQuantity = discountedQuantity;
    this.discount = discount;
  }

  @Override
  public int priceFor(double count, LinearPricing linearPricing) {
    double blockSize = requiredQuantity + discountedQuantity;
    int completeBlocks = (int) Math.floor(count / blockSize);
    double incompleteBlock = count - completeBlocks * blockSize;

    double withNormalPricing = completeBlocks * requiredQuantity + Math.min(blockSize, incompleteBlock);
    double numDiscounted = count - withNormalPricing;

    return linearPricing.priceFor(withNormalPricing) + ceil(((100.0 - discount) / 100.0) * linearPricing
        .priceFor(numDiscounted));
  }
}
