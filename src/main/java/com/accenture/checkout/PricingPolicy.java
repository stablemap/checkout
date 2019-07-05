package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingPolicy {

  private Map<String, FractionalItemPricing> unitPrices = new HashMap<>();
  private Map<String, SpecialUnitPricing> specialUnitPricing = new HashMap<>();

  private Map<String, Integer> pricesPerPound = new HashMap<>();

  public void setPricePerUnit(String itemName, int price) {
    unitPrices.put(itemName, new FractionalItemPricing(price));
  }

  public void setMarkdownPerUnit(String itemName, int amount) {
    unitPrices.get(itemName).setMarkdownPerUnit(amount);
  }

  public boolean pricesUnit(String itemName) {
    return unitPrices.containsKey(itemName);
  }

  public int priceForUnits(String itemName, int count) {
    if (specialUnitPricing.containsKey(itemName)) {
      return specialUnitPricing.get(itemName).priceForUnits(count, unitPrices.get(itemName));
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

  public void setUnitSpecial(String itemName, SpecialUnitPricing pricingByMultiple) {
    specialUnitPricing.put(itemName, pricingByMultiple);
  }
}
