package com.accenture.checkout;

public interface SpecialPricing {

  int priceFor(double itemQuantity, LinearPricing linearPricing);
}
