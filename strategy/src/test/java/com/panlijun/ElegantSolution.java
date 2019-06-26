package com.panlijun;

import com.panlijun.strategy.InvalidRouterTypeException;
import com.panlijun.strategy.Router;
import com.panlijun.strategy.RouterFactoryImpl;
import org.junit.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ElegantSolution {
    private static final Logger log = getLogger(ElegantSolution.class);

    @Test
    public void elegantRouting() throws InvalidRouterTypeException {
        Condition condition = new Condition();
        condition.setFlow(2);
        Router router = new RouterFactoryImpl().makeRouter(condition);
        log.info(router.route());
    }
}
