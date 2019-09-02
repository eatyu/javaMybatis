package com.jmybatis.agent.cglibproxy.example2;

/**
 * @Author: eatyu
 * @Description:
 * @Date: 2019/9/2 10:27
 */
public class App {
    public static void main(String[] args) {
        ExplainService proxy = ProxyFactory.getProxy(ExplainService.class);
        proxy.print();
    }
}
