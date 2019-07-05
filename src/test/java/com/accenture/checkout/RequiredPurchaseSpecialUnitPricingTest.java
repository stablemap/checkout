package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RequiredPurchaseSpecialUnitPricingTest {

  @Test
  void priceForUnits_twoItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    BasicUnitPricing basicUnitPricing = new BasicUnitPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(2, basicUnitPricing)).isEqualTo(599);
  }

  @Test
  void priceForUnits_oneItemBogoHalfOff_normalPrice() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    BasicUnitPricing basicUnitPricing = new BasicUnitPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(1, basicUnitPricing)).isEqualTo(399);
  }

  @Test
  void priceForUnits_threeItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    BasicUnitPricing basicUnitPricing = new BasicUnitPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(3, basicUnitPricing)).isEqualTo(998);
  }
}
