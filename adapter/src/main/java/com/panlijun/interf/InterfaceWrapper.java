package com.panlijun.interf;

/**
 * 接口适配器
 *
 * 当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可
 *
 * @author panlijun
 */
public abstract class InterfaceWrapper implements ISource{
    @Override
    public void m1(){}

    @Override
    public void m2(){}

}
