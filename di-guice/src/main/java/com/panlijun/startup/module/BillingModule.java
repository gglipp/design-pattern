package com.panlijun.startup.module;

import com.google.inject.AbstractModule;
import com.panlijun.startup.*;

/**
 * @author panlijun
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypayCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
