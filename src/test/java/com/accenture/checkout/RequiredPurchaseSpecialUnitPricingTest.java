package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RequiredPurchaseSpecialUnitPricingTest {

  @Test
  void priceForUnits_twoItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    FractionalItemPricing fractionalItemPricing = new FractionalItemPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(2, fractionalItemPricing)).isEqualTo(599);
  }

  @Test
  void priceForUnits_oneItemBogoHalfOff_normalPrice() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    FractionalItemPricing fractionalItemPricing = new FractionalItemPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(1, fractionalItemPricing)).isEqualTo(399);
  }

  @Test
  void priceForUnits_threeItemsBogoHalfOff_oneDiscounted() {
    RequiredPurchaseSpecialUnitPricing requiredPurchasePricing = new RequiredPurchaseSpecialUnitPricing(1, 1, 50);
    FractionalItemPricing fractionalItemPricing = new FractionalItemPricing(399);

    assertThat(requiredPurchasePricing.priceForUnits(3, fractionalItemPricing)).isEqualTo(998);
  }
}
