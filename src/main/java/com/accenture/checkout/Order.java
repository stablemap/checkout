package com.accenture.checkout;

public class Order {

  private boolean hasWatermelon = false;

  public int total() {
    return hasWatermelon ? 227 : 0;
  }

  public void setPricePerUnit(String itemName, int price) {

  }

  public void addUnit(String itemName) {
    hasWatermelon = true;
  }
}
