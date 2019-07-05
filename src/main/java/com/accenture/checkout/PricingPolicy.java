package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, LinearPricing> unitPrices = new HashMap<>();
  private Map<String, SpecialPricing> unitSpecials = new HashMap<>();

  private Map<String, LinearPricing> weightPrices = new HashMap<>();

  public void setPricePerUnit(String itemName, int price) {
    unitPrices.put(itemName, new LinearPricing(price));
  }

  public void setMarkdownPerUnit(String itemName, int amount) {
    unitPrices.get(itemName).setMarkdown(amount);
  }

  public void setUnitSpecial(String itemName, SpecialPricing pricingByMultiple) {
    unitSpecials.put(itemName, pricingByMultiple);
  }

  public boolean pricesUnit(String itemName) {
    return unitPrices.containsKey(itemName);
  }

  public int priceForUnits(String itemName, int count) {
    if (unitSpecials.containsKey(itemName)) {
      return unitSpecials.get(itemName).priceFor(count, unitPrices.get(itemName));
    }
    return unitPrices.get(itemName).priceFor(count);
  }

  public void setPricePerPound(String itemName, int price) {
    weightPrices.put(itemName, new LinearPricing(price));
  }

  public boolean pricesWeight(String itemName) {
    return weightPrices.containsKey(itemName);
  }

  public int priceForWeight(String itemName, double pounds) {
    return weightPrices.get(itemName).priceFor(pounds);
  }
}
