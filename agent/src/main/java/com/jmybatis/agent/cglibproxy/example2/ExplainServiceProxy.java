package com.jmybatis.agent.cglibproxy.example2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: eatyu
 * @Description:
 * @Date: 2019/9/2 10:06
 */
public class ExplainServiceProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强开始");

        Object result = methodProxy.invokeSuper(o, objects);

        System.out.println("增强结束");
        return result;
    }
}
