package com.panlijun.staticproxy;


import com.panlijun.Subject;
import com.panlijun.SubjectImpl;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author panlijun
 */
public class StaticProxy implements Subject {

    private static final Logger log = getLogger(StaticProxy.class);

    @Override
    public String invoke(String arg) {
        Subject subject = new SubjectImpl();
        subject.invoke("hello");
        wrap();
        return null;
    }

    private void wrap() {
        log.info("do something else....");
    }
}
