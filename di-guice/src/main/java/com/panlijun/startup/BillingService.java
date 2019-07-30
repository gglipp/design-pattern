package com.panlijun.startup;

/**
 * @author panlijun
 */
public interface BillingService {

    Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
