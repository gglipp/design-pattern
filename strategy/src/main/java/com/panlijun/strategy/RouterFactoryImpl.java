package com.panlijun.strategy;

import com.panlijun.Condition;
import org.apache.commons.lang3.StringUtils;

/**
 * 隐藏具体的判断逻辑
 * @author panlijun
 */
public class RouterFactoryImpl implements RouterFactory {

    @Override
    public Router makeRouter(Condition condition) throws InvalidRouterTypeException {
        if (condition.getFlow() == 0) {
            if (StringUtils.isBlank(condition.getMerchantCode())) {
                return new UpRouterImpl();
            } else {
                return new UpMerchantRouterImpl();
            }
        } else if (condition.getFlow() == 1) {
            return new MidRouterImpl();
        } else if (condition.getFlow() == 2){
            return new DownRouterImpl();
        } else {
            throw new InvalidRouterTypeException();
        }
    }
}
