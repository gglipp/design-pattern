package com.panlijun.strategy;

/**
 * downflow router impl
 * @author panlijun
 */
public class DownRouterImpl implements Router{
    @Override
    public String route() {
        return "/downflow";
    }
}
