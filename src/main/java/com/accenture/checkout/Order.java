package com.accenture.checkout;

public class Order {

  private int lastPrice = 0;

  public int total() {
    return lastPrice;
  }

  public void setPricePerUnit(String itemName, int price) {
    this.lastPrice = price;
  }

  public void addUnit(String itemName) {

  }
}
