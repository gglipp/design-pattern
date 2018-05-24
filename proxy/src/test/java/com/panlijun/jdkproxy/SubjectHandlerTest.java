package com.panlijun.jdkproxy;

import com.panlijun.Subject;
import com.panlijun.SubjectImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class SubjectHandlerTest {
    @Test
    public void invoke() throws Exception {
        Subject subject = (Subject) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class<?>[]{Subject.class},
                new SubjectHandler(new SubjectImpl())
        );
        subject.invoke("hi");

    }

}