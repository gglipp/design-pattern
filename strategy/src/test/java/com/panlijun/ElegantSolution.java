package com.panlijun;

import com.panlijun.abstractfactory.InvalidRouterTypeException;
import com.panlijun.router.Router;
import com.panlijun.abstractfactory.RouterFactoryImpl;
import org.junit.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class ElegantSolution {
    private static final Logger log = getLogger(ElegantSolution.class);

    @Test
    public void elegantRouting() throws InvalidRouterTypeException {
        Condition condition = new Condition();

        Router router = new RouterFactoryImpl().makeRouter(condition);

        log.info(router.route());
    }
}
