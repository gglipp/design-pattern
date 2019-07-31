package com.panlijun.startup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.panlijun.startup.module.BillingModule;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard();

    private final TransactionLog transactionLog = new DatabaseTransactionLog();
    private final CreditCardProcessor processor = new PaypayCreditCardProcessor();

//    @Before
//    public void setUp() {
//        TransactionLogFactory.setInstance(transactionLog);
//        CreditCardProcessorFactory.setInstance(processor);
//
//    }


//    @Test
//    public void should_get_successful_receipt_if_charge_successfully(){
//        //given
//        BillingService billingService = new RealBillingService();
//        PizzaOrder order = new PizzaOrder(100);
//        CreditCard creditCard = new CreditCard();
//
//        //when
//        Receipt receipt = billingService.chargeOrder(order, creditCard);
//
//        //then
//        Assertions.assertThat(receipt.getMessage()).isEqualTo(Message.CHARGE_SUCCESSFULLY);
//
//    }

    @Test
    public void should_get_successful_receipt_if_charge_successfully_with_factory(){
       //given
//        BillingService billingService = new RealBillingService();
        BillingService billingService = new RealBillingService(processor, transactionLog);
        //when
        Receipt receipt = billingService.chargeOrder(order, creditCard);

       //then
        Assertions.assertThat(receipt.getMessage()).isEqualTo(Message.CHARGE_SUCCESSFULLY);
    }

//    @After
//    public void tearDown() {
//        TransactionLogFactory.setInstance(null);
//        CreditCardProcessorFactory.setInstance(null);
//
//    }

    @Test
    public void should_get_successful_receipt_if_charge_successfully_using_guice(){
       //given
        Injector injector = Guice.createInjector(new BillingModule());
        BillingService billingService = injector.getInstance(BillingService.class);

        //when
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        //then
        Assertions.assertThat(receipt.getMessage()).isEqualTo(Message.CHARGE_SUCCESSFULLY);

    }

}
