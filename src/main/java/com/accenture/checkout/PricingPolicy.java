package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, Integer> pricesPerUnit = new HashMap<>();

  public void setUnitPrice(String itemName, int unitPrice) {
    pricesPerUnit.put(itemName, unitPrice);
  }

  public boolean pricesUnits(String itemName) {
    return pricesPerUnit.containsKey(itemName);
  }

  public int priceForUnits(String itemName, int count) {
    return count * pricesPerUnit.get(itemName);
  }
}
