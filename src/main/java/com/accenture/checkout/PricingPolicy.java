package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, Integer> pricesPerUnit = new HashMap<>();
  private Map<String, Integer> pricesPerPound = new HashMap<>();

  public void setPricePerUnit(String itemName, int price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price " + price + " is negative");
    }
    pricesPerUnit.put(itemName, price);
  }

  public boolean pricesUnit(String itemName) {
    return pricesPerUnit.containsKey(itemName);
  }

  public int priceForUnits(String itemName, int count) {
    return count * pricesPerUnit.get(itemName);
  }

  public void setPricePerPound(String itemName, int price) {
    pricesPerPound.put(itemName, price);
  }

  public boolean pricesWeight(String itemName) {
    return pricesPerPound.containsKey(itemName);
  }

  public int priceForWeight(String itemName, double pounds) {
    return (int) Math.ceil(pounds * pricesPerPound.get(itemName));
  }
}
