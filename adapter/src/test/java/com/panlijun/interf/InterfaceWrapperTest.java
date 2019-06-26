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

    @Test
    public void testPlus(){
        int x = 5;
        x += 3.5;
        System.out.println(x);
        System.out.println(x + 3.5);
    }

    @Test
    public void testBitTrans(){
        int n = 8;
        int forthBitFromRight = (n & (1 << 3)) >> 3;
        System.out.println(forthBitFromRight);
    }

}