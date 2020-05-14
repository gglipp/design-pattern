package com.panlijun;

import com.panlijun.model.MyData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IntersectionTest {

    private List datum = new ArrayList();

    private List nums = new ArrayList();

    @Before
    public void setUp() {
        datum.add(new MyData(1));
        datum.add(new MyData(2));
        datum.add(new MyData(3));
        datum.add(new MyData(4));


    }

    @Test
    public void should_intersection(){

    }
}
