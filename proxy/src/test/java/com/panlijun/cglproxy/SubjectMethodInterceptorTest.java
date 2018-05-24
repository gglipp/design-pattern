package com.panlijun.cglproxy;

import com.panlijun.CGLIBSubject;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectMethodInterceptorTest {
    @Test
    public void intercept() throws Exception {

        //通过CGLIB获取代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBSubject.class);
        enhancer.setCallback(new SubjectMethodInterceptor());

        CGLIBSubject cglibSubject = (CGLIBSubject) enhancer.create();
        cglibSubject.say("hello CGLIB!");
        cglibSubject.finalSay("final CGLIB!");
    }

}