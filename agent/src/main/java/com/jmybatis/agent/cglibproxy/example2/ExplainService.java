package com.jmybatis.agent.cglibproxy.example2;

/**
 * @Author: eatyu
 * @Description:
 * @Date: 2019/9/2 10:02
 */
public class ExplainService {


    /**
     * 这个方法可以被代理类覆写
     * <p>
     * CGLib会从被代理的类，派生出一个子类，然后在子类中覆写所有非final的public方法
     */
    public void print() {
        System.out.println(getDesc());
    }

    /**
     * 这个方法不可以被代理类覆写
     */
    private String getDesc() {
        return "这是一个“解释” ";
    }
}
