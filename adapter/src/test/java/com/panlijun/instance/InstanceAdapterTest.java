package com.panlijun.instance;

import com.panlijun.Source;
import org.junit.Test;

public class InstanceAdapterTest {

    @Test
    public void testWrapper(){
        InstanceWrapper wrapper = new InstanceWrapper(new Source());
        wrapper.m1();
        wrapper.m2();

    }

}