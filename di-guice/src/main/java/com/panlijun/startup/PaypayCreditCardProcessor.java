package com.panlijun.startup;

public class PaypayCreditCardProcessor implements CreditCardProcessor {
    @Override
    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException{
        return new ChargeResult();
    }
}
