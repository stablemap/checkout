package com.accenture.checkout;

public class FractionalItemPricing {

  private int basePrice;
  private int markdownPerUnit = 0;

  FractionalItemPricing(int basePrice) {
    if (basePrice < 0) {
      throw new IllegalArgumentException("Price " + basePrice + " is negative");
    }
    this.basePrice = basePrice;
  }

  void setMarkdownPerUnit(int markdownPerUnit) {
    this.markdownPerUnit = markdownPerUnit;
  }

  int priceFor(double itemAmount) {
    return (int) Math.ceil(itemAmount * (basePrice - markdownPerUnit));
  }
}
