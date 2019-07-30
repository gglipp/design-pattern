package com.panlijun.startup;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BillingServiceTest {

    @Test
    public void should_get_successful_receipt_if_charge_successfully(){
        //given
        BillingService billingService = new RealBillingService();
        PizzaOrder order = new PizzaOrder(100);
        CreditCard creditCard = new CreditCard();

        //when
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        //then
        Assertions.assertThat(receipt.getMessage()).isEqualTo(Message.CHARGE_SUCCESSFULLY);

    }
}
