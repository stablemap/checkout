package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OrderTest {

  private Order order = new Order();

  @Test
  void total_noPricesEmptyOrder_isZero() {
    assertThat(order.total()).isZero();
  }

  @Test
  void total_onePriceEmptyOrder_isZero() {
    order.setPricePerUnit("watermelon", 227);
    assertThat(order.total()).isZero();
  }

  @Test
  void total_oneUnit_isUnitPrice() {
    order.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");

    assertThat(order.total()).isEqualTo(227);
  }

  @Test
  void total_twoUnitsOfTheSameItem_isDoubleUnitPrice() {
    order.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");
    order.addUnit("watermelon");

    assertThat(order.total()).isEqualTo(454);
  }
}
