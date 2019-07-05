package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class XForYSpecialPricingTest {

  private XForYSpecialPricing xfysup = new XForYSpecialPricing(8, 100);
  private LinearItemPricing linearItemPricing = new LinearItemPricing(70);

  @Test
  void priceForUnits_halfSpecialMultiple_isHalfOfSpecialPrice() {
    assertThat(xfysup.priceFor(4, linearItemPricing)).isEqualTo(50);
  }

  @Test
  void priceForUnits_fractionOfSpecialMultiple_isSameFractionOfSpecialPriceRoundedUp() {
    assertThat(xfysup.priceFor(5, linearItemPricing)).isEqualTo(63);
  }
}
