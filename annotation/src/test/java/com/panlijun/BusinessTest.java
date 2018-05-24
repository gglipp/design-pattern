package com.panlijun;

import com.panlijun.annotation.CallCountableProcessor;
import org.junit.Test;

import static org.junit.Assert.*;

public class BusinessTest {
    @Test
    public void invoke() throws Exception {
        CallCountableProcessor.count(Business.class);
    }

}