package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class XForYSpecialUnitPricingTest {

  private XForYSpecialUnitPricing xfysup = new XForYSpecialUnitPricing(8, 100);
  private FractionalItemPricing fractionalItemPricing = new FractionalItemPricing(70);

  @Test
  void priceForUnits_halfSpecialMultiple_isHalfOfSpecialPrice() {
    assertThat(xfysup.priceForUnits(4, fractionalItemPricing)).isEqualTo(50);
  }

  @Test
  void priceForUnits_fractionOfSpecialMultiple_isSameFractionOfSpecialPriceRoundedUp() {
    assertThat(xfysup.priceForUnits(5, fractionalItemPricing)).isEqualTo(63);
  }
}
