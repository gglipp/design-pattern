package com.panlijun.startup;

/**
 * @author panlijun
 */
public class CreditCardProcessorFactory {
    private static CreditCardProcessor instance;

    public static void setInstance(CreditCardProcessor processor) {
        instance = processor;
    }

    public static CreditCardProcessor getInstance(){
        if (instance == null) {
            return new PaypayCreditCardProcessor();
        }
        return instance;
    }

}
