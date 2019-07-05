package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RequiredPurchaseSpecialPricingTest {

  @Test
  void priceForUnits_twoItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialPricing requiredPurchasePricing = new RequiredPurchaseSpecialPricing(1, 1, 50);
    LinearItemPricing linearItemPricing = new LinearItemPricing(399);

    assertThat(requiredPurchasePricing.priceFor(2, linearItemPricing)).isEqualTo(599);
  }

  @Test
  void priceForUnits_oneItemBogoHalfOff_normalPrice() {
    RequiredPurchaseSpecialPricing requiredPurchasePricing = new RequiredPurchaseSpecialPricing(1, 1, 50);
    LinearItemPricing linearItemPricing = new LinearItemPricing(399);

    assertThat(requiredPurchasePricing.priceFor(1, linearItemPricing)).isEqualTo(399);
  }

  @Test
  void priceForUnits_threeItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialPricing requiredPurchasePricing = new RequiredPurchaseSpecialPricing(1, 1, 50);
    LinearItemPricing linearItemPricing = new LinearItemPricing(399);

    assertThat(requiredPurchasePricing.priceFor(3, linearItemPricing)).isEqualTo(998);
  }

  @Test
  void priceForUnits_sixItemsBuyTwoGetThreeFree_payForThree() {
    RequiredPurchaseSpecialPricing requiredPurchasePricing = new RequiredPurchaseSpecialPricing(2, 3, 100);
    LinearItemPricing linearItemPricing = new LinearItemPricing(329);

    assertThat(requiredPurchasePricing.priceFor(6, linearItemPricing)).isEqualTo(987);
  }
}
