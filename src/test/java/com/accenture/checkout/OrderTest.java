package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void total_emptyOrder_isZero() {
    Order order = new Order();
    assertThat(order.total()).isZero();
  }
}
