package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, Integer> basePricesPerUnit = new HashMap<>();
  private Map<String, Integer> markdownPerUnit = new HashMap<>();
  private Map<String, UnitPricing> unitPricing = new HashMap<>();

  private Map<String, Integer> pricesPerPound = new HashMap<>();

  public void setPricePerUnit(String itemName, int price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price " + price + " is negative");
    }
    basePricesPerUnit.put(itemName, price);
  }

  public void setMarkdownPerUnit(String itemName, int amount) {
    markdownPerUnit.put(itemName, amount);
  }

  public boolean pricesUnit(String itemName) {
    return basePricesPerUnit.containsKey(itemName);
  }

  public int priceForUnits(String itemName, int count) {
    if (unitPricing.containsKey(itemName)) {
      return unitPricing.get(itemName).priceForUnits(count, pricePerUnit(itemName));
    }
    return count * pricePerUnit(itemName);
  }

  private int pricePerUnit(String itemName) {
    return basePricesPerUnit.get(itemName) - markdownPerUnit.getOrDefault(itemName, 0);
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

  public void setUnitSpecial(String itemName, UnitPricing pricingByMultiple) {
    unitPricing.put(itemName, pricingByMultiple);
  }
}
