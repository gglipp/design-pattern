package com.panlijun.cglproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * CGLIB动态代理，通过生成被代理对象子类实现，不能代理final类、final方法
 * @author panlijun
 */
public class SubjectMethodInterceptor implements MethodInterceptor{
    private static final Logger log = getLogger(SubjectMethodInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("CGLIB 代理方法。 请求参数:{}", Arrays.toString(args));
        return methodProxy.invokeSuper(o, args);
    }
}
