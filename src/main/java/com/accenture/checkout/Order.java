package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order {

  private PricingPolicy pricingPolicy;

  private Map<String, Integer> unitsHeld = new HashMap<>();
  private Map<String, Double> weightHeld = new HashMap<>();

  public Order(PricingPolicy pricingPolicy) {
    this.pricingPolicy = pricingPolicy;
  }

  public int total() {
    int totalForUnits = 0;

    for (Entry<String, Integer> entry : unitsHeld.entrySet()) {
      String itemName = entry.getKey();
      Integer units = entry.getValue();

      totalForUnits += pricingPolicy.priceForUnits(itemName, units);
    }

    int totalForWeight = 0;

    for (Entry<String, Double> entry : weightHeld.entrySet()) {
      String itemName = entry.getKey();
      double pounds = entry.getValue();

      totalForUnits += pricingPolicy.priceForWeight(itemName, pounds);
    }

    return totalForUnits + totalForWeight;
  }

  public void addUnit(String itemName) {
    if (!pricingPolicy.pricesUnit(itemName)) {
      throw new MissingPriceException(itemName);
    }
    unitsHeld.put(itemName, unitsHeld.getOrDefault(itemName, 0) + 1);
  }

  public void removeUnit(String itemName) {
    if (!unitsHeld.containsKey(itemName) || unitsHeld.get(itemName) == 0) {
      throw new MissingItemException(itemName);
    }
    unitsHeld.put(itemName, unitsHeld.get(itemName) - 1);
  }

  public void addWeight(String itemName, double weight) {
    if (!pricingPolicy.pricesWeight(itemName)) {
      throw new MissingPriceException(itemName);
    }
    weightHeld.put(itemName, weightHeld.getOrDefault(itemName, 0.0) + weight);
  }

  public void removeWeight(String itemName, double weight) {
    weightHeld.put(itemName, weightHeld.get(itemName) - weight);
  }
}
