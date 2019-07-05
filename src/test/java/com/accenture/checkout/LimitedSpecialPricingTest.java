package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LimitedSpecialPricingTest {

  private XForYSpecialPricing xfysup = new XForYSpecialPricing(8, 100);
  private LimitedSpecialPricing lsup = new LimitedSpecialPricing(xfysup, 8);
  private LinearItemPricing bup = new LinearItemPricing(70);

  @Test
  void priceForUnits_underLimit_appliesSpecialToAllUnits() {
    assertThat(lsup.priceFor(3, bup)).isEqualTo(38);
  }

  @Test
  void priceForUnits_overLimit_usesNormalPriceForLeftovers() {
    assertThat(lsup.priceFor(10, bup)).isEqualTo(240);
  }
}
