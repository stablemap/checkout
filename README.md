A performance of the [checkout kata](https://github.com/PillarTechnology/kata-checkout-order-total).

This project is developed on JDK 8. To run the tests, execute

```shell
./gradlew test
```

This should take care of downloading the small set of dependencies of the library.

The API is designed for integration with a user interface. At the most basic level one can price an item by unit or weight, add or remove quantities of items, and check on the value of an order at any time:

```java
PricingPolicy pricingPolicy = new PricingPolicy();
pricingPolicy.setPricePerUnit("cheese", 369);

Order order = new Order(pricingPolicy);
order.addUnit("cheese");
log.info("Order subtotal is " + order.total());
```

Note that all prices are given in cents. More complex pricing is available—an offer for 5 bricks of cheese for $3 can be encoded as follows:

```java
pricingPolicy.setUnitSpecial("cheese", new BulkPricing(3, 500));
```

One can also limit the extent of a special by wrapping it appropriately:

```java
new LimitedSpecialPricing(new BulkPricing(3, 500), 6)
```

will cause the 7th brick purchased to cost the normal amount.
