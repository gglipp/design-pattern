package com.panlijun.strategy;

import com.panlijun.Condition;

/**
 * 根据Condition生成具体的router
 * @author panlijun
 */
public interface RouterFactory {

    /**
     * @param condition 路由选择条件
     * @return router
     * @throws InvalidRouterTypeException 无效路由异常
     */
    public Router makeRouter(Condition condition) throws InvalidRouterTypeException;
}
