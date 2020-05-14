package com.panlijun;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Sets;
import com.panlijun.model.MyData;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class IntersectionTest {

    private Set datum = new HashSet();
    private Set datum2 = new HashSet();

    private Set<Integer> nums = new HashSet<>();
    private Set<Integer> nums2 = new HashSet<>();

    @Before
    public void setUp() {
        datum.add(new MyData(1));
        datum.add(new MyData(2));
        datum.add(new MyData(3));
        datum.add(new MyData(4));

        datum2.add(new MyData(3));
        datum2.add(new MyData(4));
        datum2.add(new MyData(5));
        datum2.add(new MyData(6));

        nums = Sets.newHashSet(3, 4, 5, 6);
        nums2 = Sets.newHashSet(1, 2, 3, 4);

        System.out.println(datum);
        System.out.println(nums);
        System.out.println(nums2);
    }

    @Test
    public void should_intersection(){
        System.out.println(Sets.intersection(nums, datum));

        System.out.println(Sets.intersection(nums, nums2));

        System.out.println(Sets.intersection(datum, datum2));


    }

    @Test
    public void should_intersection_by_bit(){
        BitSet bitSet = new BitSet();

        for (Integer num : nums) {
            bitSet.set(num);
        }

        BitSet bitSet2 = new BitSet();

        for (Integer num : nums2) {
            bitSet2.set(num);
        }
        bitSet.and(bitSet2);

        System.out.println(bitSet.cardinality());
        System.out.println(bitSet);

    }

}
