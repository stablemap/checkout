package com.accenture.checkout;

public class MissingItemException extends RuntimeException {
  public MissingItemException(String itemName) {
    super("No units of " + itemName + " found");
  }
}
