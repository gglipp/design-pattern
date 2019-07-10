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

    @Test
    public void inheritTest(){
        Singleton instance = Singleton.getInstance();
        log.info(String.valueOf(instance.hashCode()));
        log.info(instance.getParentHashcode());
        Singleton instance1 = Singleton.getInstance();
        log.info(String.valueOf(instance1.hashCode()));
        log.info(instance1.getParentHashcode());
        log.info(String.valueOf(new NonSingleton().hashCode()));
        log.info(String.valueOf(new NonSingleton().hashCode()));
    }
}
