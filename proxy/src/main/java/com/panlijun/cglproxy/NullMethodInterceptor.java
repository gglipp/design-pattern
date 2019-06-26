package com.panlijun.cglproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 不调用被代理类方法
 * @author gglip
 */
public class NullMethodInterceptor implements MethodInterceptor {
    private static Logger log = LoggerFactory.getLogger(NullMethodInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("不调用代理方法");
        return null;
    }
}
