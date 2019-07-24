package com.panlijun.cglproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author gglip
 */
public class OtherMethodInterceptor implements MethodInterceptor{
    private static Logger log = LoggerFactory.getLogger(OtherMethodInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("this is another interceptor");
//        throw new Exception("error");
        return methodProxy.invokeSuper(o, objects);
    }
}
