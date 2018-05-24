package com.panlijun.clazz;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 类适配器
 * @author panlijun
 */
public class ClassAdapter extends Source implements Targetable{
    private static final Logger log = getLogger(ClassAdapter.class);
    @Override
    public void m2() {
        log.info("this is m2 in class adapter");
    }
}
