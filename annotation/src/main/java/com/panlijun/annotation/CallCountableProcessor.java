package com.panlijun.annotation;

import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * CallCountable注解实现
 * @author panlijun
 */
public class CallCountableProcessor {
    private static final Logger log = getLogger(CallCountableProcessor.class);

    public static void count(Class<?> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for(Method m : clazz.getMethods()) {
            if(m.isAnnotationPresent(CallCountable.class)){
                Object o = clazz.newInstance();
                m.invoke(o, "ss");
                log.info(m.getName() + "has been called. count++");
            }
        }
    }
}
