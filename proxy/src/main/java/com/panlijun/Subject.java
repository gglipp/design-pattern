package com.panlijun;

/**
 * @author panlijun
 */
public interface Subject {
    /**
     * Proxy Pattern 接口方法调用
     * @param arg 请求String
     * @return 相应String
     */
    String invoke(String arg);
}
