package com.panlijun.clazz;

import com.panlijun.Source;
import com.panlijun.Targetable;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 类适配器
 * 将Source类的功能扩展到Targetable接口
 *
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可
 *
 * @author panlijun
 */
public class ClassAdapter extends Source implements Targetable {
    private static final Logger log = getLogger(ClassAdapter.class);
    @Override
    public void m2() {
        log.info("this is m2 in class adapter");
    }
}
