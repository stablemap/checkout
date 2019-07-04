package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PricingPolicyTest {
  private PricingPolicy pricingPolicy = new PricingPolicy();

  @Test
  void setPricePerUnit_withNegativePrice_throws() {
    assertThatThrownBy(() -> pricingPolicy.setPricePerUnit("watermelon", -227))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("-227");
  }
}