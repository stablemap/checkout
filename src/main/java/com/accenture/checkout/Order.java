package com.accenture.checkout;

public class Order {

  private int lastPrice = 0;
  private int total = 0;

  public int total() {
    return total;
  }

  public void setPricePerUnit(String itemName, int price) {
    this.lastPrice = price;
  }

  public void addUnit(String itemName) {
    total = lastPrice;
  }
}
