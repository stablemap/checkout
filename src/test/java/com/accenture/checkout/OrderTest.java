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

  @Test
  void total_twoDifferentUnits_isSumOfUnitPrices() {
    order.setPricePerUnit("watermelon", 227);
    order.setPricePerUnit("beans", 188);
    order.addUnit("watermelon");
    order.addUnit("beans");

    assertThat(order.total()).isEqualTo(415);
  }

  @Test
  void total_onePoundOfItem_isWeightPrice() {
    order.setPricePerPound("beef", 179);
    order.addWeight("beef", 1.00);

    assertThat(order.total()).isEqualTo(179);
  }

  @Test
  void total_fractionOfPoundOfItem_isSameFractionOfPrice() {
    order.setPricePerPound("beef", 179);
    order.addWeight("beef", 0.53);

    assertThat(order.total()).isEqualTo(95);
  }

  @Test
  void total_twoDifferentItemsByWeight_isSumOfPrices() {
    order.setPricePerPound("beef", 179);
    order.setPricePerPound("chicken", 169);
    order.addWeight("beef", 0.53);
    order.addWeight("chicken", 0.84);

    assertThat(order.total()).isEqualTo(237);
  }
}
