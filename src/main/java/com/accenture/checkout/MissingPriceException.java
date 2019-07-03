package com.accenture.checkout;

public class MissingPriceException extends RuntimeException {
  public MissingPriceException(String itemName) {
    super("Missing price for " + itemName);
  }
}
