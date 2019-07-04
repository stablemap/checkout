package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Order {

  private Map<String, Integer> pricesPerUnit = new HashMap<>();
  private Map<String, Integer> unitsHeld = new HashMap<>();

  private Map<String, Integer> pricesPerPound = new HashMap<>();
  private Map<String, Double> weightHeld = new HashMap<>();

  public int total() {
    int totalForUnits = 0;

    for (Entry<String, Integer> entry : unitsHeld.entrySet()) {
      String itemName = entry.getKey();
      Integer units = entry.getValue();

      totalForUnits += units * pricesPerUnit.get(itemName);
    }

    int totalForWeight = 0;

    for (Entry<String, Double> entry : weightHeld.entrySet()) {
      String itemName = entry.getKey();
      double pounds = entry.getValue();

      totalForUnits += Math.ceil(pounds * pricesPerPound.get(itemName));
    }

    return totalForUnits + totalForWeight;
  }

  public void setPricePerUnit(String itemName, int price) {
    unitsHeld.put(itemName, 0);
    pricesPerUnit.put(itemName, price);
  }

  public void addUnit(String itemName) {
    if (!pricesPerUnit.containsKey(itemName)) {
      throw new MissingPriceException(itemName);
    }
    unitsHeld.put(itemName, unitsHeld.get(itemName) + 1);
  }

  public void removeUnit(String itemName) {
    if (!unitsHeld.containsKey(itemName) || unitsHeld.get(itemName) == 0) {
      throw new MissingItemException(itemName);
    }
    unitsHeld.put(itemName, unitsHeld.get(itemName) - 1);
  }

  public void setPricePerPound(String itemName, int price) {
    weightHeld.put(itemName, 0.0);
    pricesPerPound.put(itemName, price);
  }

  public void addWeight(String itemName, double weight) {
    if (!pricesPerPound.containsKey(itemName)) {
      throw new MissingPriceException(itemName);
    }
    weightHeld.put(itemName, weightHeld.get(itemName) + weight);
  }
}
