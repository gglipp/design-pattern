package com.panlijun.startup;

import com.google.inject.Inject;

/**
 * @author panlijun
 */
public class RealBillingService implements BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
//part 1
//        CreditCardProcessor processor = new PaypayCreditCardProcessor();
//        TransactionLog transactionLog = new DatabaseTransactionLog();

        //part 2
//        CreditCardProcessor processor = CreditCardProcessorFactory.getInstance();
//        TransactionLog transactionLog = TransactionLogFactory.getInstance();

        //part 3

        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);
            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclineCharge(result.getDeclineMessage());
        } catch (UnreachableException e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
