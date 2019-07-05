package com.accenture.checkout;

import static org.assertj.core.api.Assertions.assertThat;
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

  @Test
  void priceForUnits_noUnits_isZero() {
    pricingPolicy.setPricePerUnit("watermelon", 227);

    assertThat(pricingPolicy.priceForUnits("watermelon", 0)).isZero();
  }

  @Test
  void priceForUnits_oneUnit_isUnitPrice() {
    pricingPolicy.setPricePerUnit("watermelon", 227);

    assertThat(pricingPolicy.priceForUnits("watermelon", 1)).isEqualTo(227);
  }

  @Test
  void priceForUnits_twoUnits_isTwiceUnitPrice() {
    pricingPolicy.setPricePerUnit("watermelon", 227);

    assertThat(pricingPolicy.priceForUnits("watermelon", 2)).isEqualTo(454);
  }

  @Test
  void priceForUnits_oneUnitOfMarkdownDownItem_isUnitPriceLessMarkdown() {
    pricingPolicy.setPricePerUnit("milk", 399);
    pricingPolicy.setMarkdownPerUnit("milk", 100);

    assertThat(pricingPolicy.priceForUnits("milk", 1)).isEqualTo(299);
  }

  @Test
  void priceForUnits_itemWithUpdatedMarkdown_reflectsNewMarkdown() {
    pricingPolicy.setPricePerUnit("milk", 399);
    pricingPolicy.setMarkdownPerUnit("milk", 100);
    pricingPolicy.setMarkdownPerUnit("milk", 200);

    assertThat(pricingPolicy.priceForUnits("milk", 1)).isEqualTo(199);
  }

  @Test
  void priceForUnits_halfXUnitsWithXForYSpecial_costsHalfOfY() {
    pricingPolicy.setPricePerUnit("corn", 70);
    pricingPolicy.setUnitSpecial("corn", new XForYSpecialUnitPricing(8, 100));

    assertThat(pricingPolicy.priceForUnits("corn", 4)).isEqualTo(50);
  }
}
