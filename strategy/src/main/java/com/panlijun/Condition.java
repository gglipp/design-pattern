package com.panlijun;

/**
 * @author panlijun
 *
 * 条件： flow和merchantCode控制路由方向
 * flow=0 & merchantCode为空，路由方向：/upflow;
 * flow=0 & merchantCode不为空，路由方向：/upflow-merchant;
 * flow=1，路由方向：/midflow；
 * flow=2, 路由方向：/downflow
 */
public class Condition{

    private int flow;
    private String merchantCode;

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }
}
