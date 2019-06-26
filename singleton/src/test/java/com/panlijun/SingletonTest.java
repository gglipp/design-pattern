package com.panlijun;

import static org.junit.Assert.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;

/**
 * Unit test for simple App.
 */
public class SingletonTest {

    private static final Logger log = getLogger(SingletonTest.class);

    @Test
    public void singletenTest() {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        Assert.assertEquals(instance, instance1);
    }

    @Test
    public void nonSingletonTest() {
        NonSingleton nonSingleton = new NonSingleton();
        NonSingleton nonSingleton1 = new NonSingleton();
        Assert.assertEquals(nonSingleton, nonSingleton1);
    }
}
