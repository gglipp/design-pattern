package com.panlijun.interf;

import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceWrapperTest {

    @Test
    public void testWrapper(){
        SourceImpl1 s1 = new SourceImpl1();
        SourceImpl2 s2 = new SourceImpl2();
        s1.m1();
        s1.m2();
        s2.m1();
        s2.m2();
    }

}