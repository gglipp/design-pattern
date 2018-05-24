package com.panlijun.interf;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class SourceImpl2 extends InterfaceWrapper{
    private static final Logger log = getLogger(SourceImpl2.class);

    @Override
    public void m2(){
        log.info("this is m2 in sourceImpl 2");
    }
}
