package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, LinearItemPricing> unitPrices = new HashMap<>();
  private Map<String, SpecialPricing> unitSpecials = new HashMap<>();

  private Map<String, Integer> pricesPerPound = new HashMap<>();

  public void setPricePerUnit(String itemName, int price) {
    unitPrices.put(itemName, new LinearItemPricing(price));
  }

  public void setMarkdownPerUnit(String itemName, int amount) {
    unitPrices.get(itemName).setMarkdown(amount);
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
    pricesPerPound.put(itemName, price);
  }

  public boolean pricesWeight(String itemName) {
    return pricesPerPound.containsKey(itemName);
  }

  public int priceForWeight(String itemName, double pounds) {
    return (int) Math.ceil(pounds * pricesPerPound.get(itemName));
  }

  public void setUnitSpecial(String itemName, SpecialPricing pricingByMultiple) {
    unitSpecials.put(itemName, pricingByMultiple);
  }
}
