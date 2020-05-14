package com.panlijun;

import com.panlijun.model.MyData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        nums = Arrays.asList(3, 4, 5, 6);

        System.out.println(datum);
        System.out.println(nums);
    }

    @Test
    public void should_intersection(){

        // 0000 0001
        byte a = 1;
        // 0000 0011
        byte b = 3;

        //结果是1
        // 0000 0001
        System.out.println(a&b);

    }
}
