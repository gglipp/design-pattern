package com.panlijun.startup;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author panlijun
 */
public class Receipt {

    private String message;

    private static final Logger log = getLogger(Receipt.class);

    public static Receipt forSuccessfulCharge(int amount) {

        String message = Message.CHARGE_SUCCESSFULLY;
        return new Receipt().log(message).recordMessage(message);
    }

    public static Receipt forDeclineCharge(String declineMessage) {
        String message = Message.CHARGE_DECLINED;
        return new Receipt().log(message).recordMessage(message);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt().log(message).recordMessage(message);
    }

    private Receipt log(String message) {
        log.info(message);
        return this;
    }

    private Receipt recordMessage(String message) {
        this.message = message;
        return this;
    }

    public String getMessage() {
        return message;
    }
}
