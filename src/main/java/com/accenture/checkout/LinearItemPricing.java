package com.accenture.checkout;

public class LinearItemPricing {

  private int basePrice;
  private int markdown = 0;

  LinearItemPricing(int basePrice) {
    if (basePrice < 0) {
      throw new IllegalArgumentException("Price " + basePrice + " is negative");
    }
    this.basePrice = basePrice;
  }

  void setMarkdown(int markdown) {
    this.markdown = markdown;
  }

  int priceFor(double itemAmount) {
    return (int) Math.ceil(itemAmount * (basePrice - markdown));
  }
}
