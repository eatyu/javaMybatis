package com.jmybatis.agent.cglibproxy.example2;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: eatyu
 * @Description:
 * @Date: 2019/9/2 10:15
 */
public class ProxyFactory {
    /**
     * 创建代理对象实例
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> type) {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(type);

        // 代理类
        ExplainServiceProxy proxy = new ExplainServiceProxy();

        en.setCallback(proxy);
        //注意：被代理的类，必须有默认无参的空构造函数
        T instance = (T) en.create();
        return instance;

    }
}
