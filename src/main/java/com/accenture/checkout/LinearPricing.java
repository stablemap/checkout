package com.accenture.checkout;

import static com.accenture.checkout.Utilities.ceil;

class LinearPricing {

  private int basePrice;
  private int markdown = 0;

  LinearPricing(int basePrice) {
    if (basePrice < 0) {
      throw new IllegalArgumentException("Price " + basePrice + " is negative");
    }
    this.basePrice = basePrice;
  }

  void setMarkdown(int markdown) {
    this.markdown = markdown;
  }

  int priceFor(double itemAmount) {
    return ceil(itemAmount * (basePrice - markdown));
  }
}
