package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class Order {

  private int total = 0;

  private Map<String, Integer> pricesPerUnit = new HashMap<>();
  private Map<String, Integer> pricesPerPound = new HashMap<>();

  private Map<String, Integer> unitsHeld = new HashMap<>();

  public int total() {
    return total;
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
    total += pricesPerUnit.get(itemName);
  }

  public void removeUnit(String itemName) {
    if (!unitsHeld.containsKey(itemName) || unitsHeld.get(itemName) == 0) {
      throw new MissingItemException(itemName);
    }
    unitsHeld.put(itemName, unitsHeld.get(itemName) - 1);
    total -= pricesPerUnit.get(itemName);
  }

  public void setPricePerPound(String itemName, int price) {
    pricesPerPound.put(itemName, price);
  }

  public void addWeight(String itemName, double weight) {
    if (!pricesPerPound.containsKey(itemName)) {
      throw new MissingPriceException(itemName);
    }
    total += Math.ceil(weight * pricesPerPound.get(itemName));
  }
}
