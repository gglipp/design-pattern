package com.panlijun.abstractfactory;

import com.panlijun.Condition;
import com.panlijun.router.Router;

/**
 * 根据Condition生成具体的router
 * @author panlijun
 */
public interface RouterFactory {

    /**
     * router生成逻辑
     * @param condition 路由选择条件
     * @return router
     * @throws InvalidRouterTypeException 无效路由异常
     */
    Router makeRouter(Condition condition) throws InvalidRouterTypeException;
}
