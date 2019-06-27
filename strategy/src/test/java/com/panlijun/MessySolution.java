package com.panlijun;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class MessySolution {

    private static final Logger log = getLogger(MessySolution.class);

    @Test
    public void messyRouting(){

        Condition condition = new Condition();

        if (condition.getFlow() == 0) {
            if (StringUtils.isBlank(condition.getMerchantCode())) {
                log.info("routing '/upflow'");
            } else {
                log.info("routing '/upflow-merchant'");
            }
        } else if (condition.getFlow() == 1) {
            log.info("routing '/midflow'");
        } else {
            log.info("routing '/downflow'");
        }
    }
}
