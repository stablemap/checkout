package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LimitedSpecialUnitPricingTest {

  private XForYSpecialUnitPricing xfysup = new XForYSpecialUnitPricing(8, 100);
  private LimitedSpecialUnitPricing lsup = new LimitedSpecialUnitPricing(xfysup, 8);
  private BasicUnitPricing bup = new BasicUnitPricing(70);

  @Test
  void priceForUnits_underLimit_appliesSpecialToAllUnits() {
    assertThat(lsup.priceForUnits(3, bup)).isEqualTo(38);
  }

  @Test
  void priceForUnits_overLimit_usesNormalPriceForLeftovers() {
    assertThat(lsup.priceForUnits(10, bup)).isEqualTo(240);
  }
}