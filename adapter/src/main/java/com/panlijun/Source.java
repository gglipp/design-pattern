package com.panlijun;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 原始类，拥有方法m1(),需要适配Targetable接口
 * @author panlijun
 */
public class Source {
    private static final Logger log = getLogger(Source.class);
    public void m1(){
        log.info("this is m1 in Source");
    }
}
