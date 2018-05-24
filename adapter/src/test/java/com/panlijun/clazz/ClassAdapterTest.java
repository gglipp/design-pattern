package com.panlijun.clazz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassAdapterTest {

    @Test
    public void testAdapter(){
        ClassAdapter adapter = new ClassAdapter();
        adapter.m1();
        adapter.m2();
    }

}