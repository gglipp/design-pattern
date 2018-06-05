package com.panlijun.cglproxy;

import com.panlijun.CGLIBSubject;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class SubjectMethodInterceptorTest {
    @Test
    public void intercept() throws Exception {

        //通过CGLIB获取代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBSubject.class);
        /**
         * 设置单个interceptor
         */
//        enhancer.setCallback(new SubjectMethodInterceptor());

        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if ("say".equals(method.getName())){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        enhancer.setCallbacks(new Callback[]{new OtherMethodInterceptor(), new SubjectMethodInterceptor()});


        CGLIBSubject cglibSubject = (CGLIBSubject) enhancer.create();
        cglibSubject.say("hello CGLIB!");
        cglibSubject.say2("hello cglib2!");
        cglibSubject.finalSay("final CGLIB!");
    }

}