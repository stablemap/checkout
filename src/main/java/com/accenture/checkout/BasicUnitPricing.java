package com.accenture.checkout;

public class BasicUnitPricing {

  private int basePricePerUnit;
  private int markdownPerUnit = 0;

  BasicUnitPricing(int basePricePerUnit) {
    if (basePricePerUnit < 0) {
      throw new IllegalArgumentException("Price " + basePricePerUnit + " is negative");
    }
    this.basePricePerUnit = basePricePerUnit;
  }

  void setMarkdownPerUnit(int markdownPerUnit) {
    this.markdownPerUnit = markdownPerUnit;
  }

  int priceForUnits(int numUnits) {
    return numUnits * (basePricePerUnit - markdownPerUnit);
  }
}
