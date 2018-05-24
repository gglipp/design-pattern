package com.panlijun.staticproxy;


import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy(){
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.invoke("hello");
    }
}
