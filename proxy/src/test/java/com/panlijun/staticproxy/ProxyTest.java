package com.panlijun.staticproxy;


import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy() throws Exception {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.invoke("hello");
    }
}
