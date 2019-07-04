package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @Test
  void addUnit_withoutPrice_throws() {
    assertThatThrownBy(() -> order.addUnit("salad"))
        .isInstanceOf(MissingPriceException.class)
        .hasMessageContaining("salad");
  }

  @Test
  void addWeight_withoutPrice_throws() {
    assertThatThrownBy(() -> order.addWeight("steak", 1.0))
        .isInstanceOf(MissingPriceException.class)
        .hasMessageContaining("steak");
  }

  @Test
  void total_afterAddingAndRemovingUnit_isZero() {
    order.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");
    order.removeUnit("watermelon");

    assertThat(order.total()).isZero();
  }

  @Test
  void total_afterAddingTwoUnitsAndRemovingOne_isUnitPrice() {
    order.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");
    order.addUnit("watermelon");
    order.removeUnit("watermelon");

    assertThat(order.total()).isEqualTo(227);
  }

  @Test
  void removeUnit_emptyOrder_throws() {
    assertThatThrownBy(() -> order.removeUnit("watermelon"))
        .isInstanceOf(MissingItemException.class)
        .hasMessageContaining("watermelon");
  }

  @Test
  void removeUnit_noSuchUnitsInOrder_throws() {
    order.setPricePerUnit("watermelon", 227);
    order.setPricePerUnit("beans", 188);
    order.addUnit("watermelon");

    assertThatThrownBy(() -> order.removeUnit("beans"))
        .isInstanceOf(MissingItemException.class)
        .hasMessageContaining("beans");
  }
}
