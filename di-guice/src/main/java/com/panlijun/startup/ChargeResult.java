package com.panlijun.startup;

/**
 * @author panlijun
 */
public class ChargeResult {
    public boolean wasSuccessful() {
        return true;
    }

    public String getDeclineMessage() {
        return Message.CHARGE_DECLINED;
    }
}
