package com.panlijun;

import com.panlijun.annotation.CallCountable;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author panlijun
 */
public class Business {
    private static final Logger log = getLogger(Business.class);

    @CallCountable
    public void invoke(String msg) {
        log.info("method invoked. msg:{}", msg);
    }
}
