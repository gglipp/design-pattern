package com.panlijun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author panlijun
 */
public class SubjectImpl implements Subject{

    private static final Logger log = LoggerFactory.getLogger(Subject.class);

    @Override
    public String invoke(String arg) {
        log.info("subjectImpl executed. MSG:{}", arg);
        return arg;
    }
}
