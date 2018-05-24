package com.panlijun.jdkproxy;

import com.panlijun.Subject;
import org.slf4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * JDK动态代理，需要被代理对象实现接口
 * @author panlijun
 */
public class SubjectHandler implements InvocationHandler {
    private static final Logger log = getLogger(SubjectHandler.class);
    private static final String INVOKE = "invoke";

    private Subject subject;

    SubjectHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(INVOKE.equals(method.getName())) {
            log.info("请求参数:{}", Arrays.toString(args));
        }
        return method.invoke(subject, args);
    }
}
