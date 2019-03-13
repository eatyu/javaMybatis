package com.jmybatis.agent.staticproxy;

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDao();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        //执行的是代理的方法
        proxy.save();
    }
}
