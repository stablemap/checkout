package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RequiredPurchasePricingTest {

  @Test
  void priceForUnits_twoItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchasePricing requiredPurchasePricing = new RequiredPurchasePricing(1, 1, 50);
    LinearPricing linearPricing = new LinearPricing(399);

    assertThat(requiredPurchasePricing.priceFor(2, linearPricing)).isEqualTo(599);
  }

  @Test
  void priceForUnits_oneItemBogoHalfOff_normalPrice() {
    RequiredPurchasePricing requiredPurchasePricing = new RequiredPurchasePricing(1, 1, 50);
    LinearPricing linearPricing = new LinearPricing(399);

    assertThat(requiredPurchasePricing.priceFor(1, linearPricing)).isEqualTo(399);
  }

  @Test
  void priceForUnits_threeItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchasePricing requiredPurchasePricing = new RequiredPurchasePricing(1, 1, 50);
    LinearPricing linearPricing = new LinearPricing(399);

    assertThat(requiredPurchasePricing.priceFor(3, linearPricing)).isEqualTo(998);
  }

  @Test
  void priceForUnits_sixItemsBuyTwoGetThreeFree_payForThree() {
    RequiredPurchasePricing requiredPurchasePricing = new RequiredPurchasePricing(2, 3, 100);
    LinearPricing linearPricing = new LinearPricing(329);

    assertThat(requiredPurchasePricing.priceFor(6, linearPricing)).isEqualTo(987);
  }
}
