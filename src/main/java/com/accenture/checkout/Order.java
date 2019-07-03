package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class Order {

  private int total = 0;

  private Map<String, Integer> pricesPerUnit = new HashMap<>();
  private Map<String, Integer> pricesPerPound = new HashMap<>();

  public int total() {
    return total;
  }

  public void setPricePerUnit(String itemName, int price) {
    pricesPerUnit.put(itemName, price);
  }

  public void addUnit(String itemName) {
    if (!pricesPerUnit.containsKey(itemName)) {
      throw new MissingPriceException(itemName);
    }
    total += pricesPerUnit.get(itemName);
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
