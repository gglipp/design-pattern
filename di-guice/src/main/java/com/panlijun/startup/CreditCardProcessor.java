package com.panlijun.startup;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
}
