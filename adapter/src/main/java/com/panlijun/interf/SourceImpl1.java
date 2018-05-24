package com.panlijun.interf;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class SourceImpl1 extends InterfaceWrapper{

    private static final Logger log = getLogger(SourceImpl1.class);

    @Override
    public void m1(){
        log.info("this is m1 in sourceImpl 1");
    }
}
