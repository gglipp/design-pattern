package com.panlijun;

/**
 * @author panlijun
 */
public class Singleton extends Parent{
    private Singleton(){}

    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }
}
