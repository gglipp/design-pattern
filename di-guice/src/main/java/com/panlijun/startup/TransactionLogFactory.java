package com.panlijun.startup;

/**
 * @author panlijun
 */
public class TransactionLogFactory {
    private static TransactionLog instance;
    public static void setInstance(TransactionLog transactionLog) {
        instance = transactionLog;
    }

    public static TransactionLog getInstance() {
        if (instance == null) {
            return new DatabaseTransactionLog();
        }
        return instance;
    }
}
