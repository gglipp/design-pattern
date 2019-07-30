package com.panlijun.startup;

/**
 * @author panlijun
 */
public interface TransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(UnreachableException e);
}
