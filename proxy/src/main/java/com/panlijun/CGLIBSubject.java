package com.panlijun;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author panlijun
 */
public class CGLIBSubject {
    private static final Logger log = getLogger(CGLIBSubject.class);

    public String say(String msg) {
        log.info("CGI subject says:{}", msg);
        return msg;
    }

    public String say2(String msg){
        log.info("CGI subject says2:{}");
        return msg;
    }

    public final String finalSay(String msg) {
        log.info("CGI subject final says:{}", msg);
        return msg;
    }
}
