package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UnlimitedSpecialUnitPricingTest {

  private UnlimitedSpecialUnitPricing usup = new UnlimitedSpecialUnitPricing(8, 100);
  private BasicUnitPricing basicUnitPricing = new BasicUnitPricing(70);

  @Test
  void priceForUnits_halfSpecialMultiple_isHalfOfSpecialPrice() {
    assertThat(usup.priceForUnits(4, basicUnitPricing)).isEqualTo(50);
  }

  @Test
  void priceForUnits_fractionOfSpecialMultiple_isSameFractionOfSpecialPriceRoundedUp() {
    assertThat(usup.priceForUnits(5, basicUnitPricing)).isEqualTo(63);
  }
}
