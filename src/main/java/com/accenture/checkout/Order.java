package com.accenture.checkout;

import java.util.HashMap;
import java.util.Map;

public class Order {

  private int total = 0;

  private Map<String, Integer> unitPrices = new HashMap<>();

  public int total() {
    return total;
  }

  public void setPricePerUnit(String itemName, int price) {
    unitPrices.put(itemName, price);
  }

  public void addUnit(String itemName) {
    total += unitPrices.get(itemName);
  }
}
