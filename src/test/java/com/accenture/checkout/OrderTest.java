package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class OrderTest {

  private PricingPolicy pricingPolicy = new PricingPolicy();
  private Order order = new Order(pricingPolicy);

  @Test
  void total_noPricesEmptyOrder_isZero() {
    assertThat(order.total()).isZero();
  }

  @Test
  void total_onePriceEmptyOrder_isZero() {
    pricingPolicy.setPricePerUnit("watermelon", 227);

    assertThat(order.total()).isZero();
  }

  @Test
  void total_oneUnit_isUnitPrice() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");

    assertThat(order.total()).isEqualTo(227);
  }

  @Test
  void total_twoUnitsOfTheSameItem_isDoubleUnitPrice() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");
    order.addUnit("watermelon");

    assertThat(order.total()).isEqualTo(454);
  }

  @Test
  void total_twoDifferentUnits_isSumOfUnitPrices() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
    pricingPolicy.setPricePerUnit("beans", 188);
    order.addUnit("watermelon");
    order.addUnit("beans");

    assertThat(order.total()).isEqualTo(415);
  }

  @Test
  void total_onePoundOfItem_isWeightPrice() {
    pricingPolicy.setPricePerPound("beef", 179);
    order.addWeight("beef", 1.00);

    assertThat(order.total()).isEqualTo(179);
  }

  @Test
  void total_fractionOfPoundOfItem_isSameFractionOfPrice() {
    pricingPolicy.setPricePerPound("beef", 179);
    order.addWeight("beef", 0.53);

    assertThat(order.total()).isEqualTo(95);
  }

  @Test
  void total_twoWeightsOfSameItem_priceRoundedUpAtEnd() {
    pricingPolicy.setPricePerPound("beef", 179);
    order.addWeight("beef", 0.52);
    order.addWeight("beef", 0.52);

    assertThat(order.total()).isEqualTo(187);
  }

  @Test
  void total_twoDifferentItemsByWeight_isSumOfPrices() {
    pricingPolicy.setPricePerPound("beef", 179);
    pricingPolicy.setPricePerPound("chicken", 169);
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
  void total_someWeightRemoved_isPriceOfRemainingWeight() {
    pricingPolicy.setPricePerPound("beef", 179);
    order.addWeight("beef", 4.65);
    order.removeWeight("beef", 2.75);

    assertThat(order.total()).isEqualTo(341);
  }

  @Test
  void total_afterAddingAndRemovingUnit_isZero() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
    order.addUnit("watermelon");
    order.removeUnit("watermelon");

    assertThat(order.total()).isZero();
  }

  @Test
  void total_afterAddingTwoUnitsAndRemovingOne_isUnitPrice() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
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
    pricingPolicy.setPricePerUnit("watermelon", 227);
    pricingPolicy.setPricePerUnit("beans", 188);
    order.addUnit("watermelon");

    assertThatThrownBy(() -> order.removeUnit("beans"))
        .isInstanceOf(MissingItemException.class)
        .hasMessageContaining("beans");
  }

  @Test
  void removeUnit_oneUnitAddedAndRemoved_throws() {
    pricingPolicy.setPricePerUnit("watermelon", 227);
    pricingPolicy.setPricePerUnit("beans", 188);
    order.addUnit("watermelon");
    order.addUnit("beans");
    order.removeUnit("beans");

    assertThatThrownBy(() -> order.removeUnit("beans"))
        .isInstanceOf(MissingItemException.class)
        .hasMessageContaining("beans");
  }
}
