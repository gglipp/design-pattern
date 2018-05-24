package com.panlijun.instance;

import com.panlijun.Source;
import com.panlijun.Targetable;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 对象适配器
 *
 * 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行
 *
 * @author panlijun
 */
public class InstanceWrapper implements Targetable{
    private static final org.slf4j.Logger log = getLogger(InstanceWrapper.class);

    private Source source;

    public InstanceWrapper(Source source) {
        this.source = source;
    }


    @Override
    public void m1() {
        source.m1();
    }

    @Override
    public void m2() {
        log.info("this is m2 in instance adapter");
    }
}
