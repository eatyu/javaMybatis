package com.jmybatis.agent.dynamicproxy;

import com.jmybatis.agent.staticproxy.IUserDao;
import com.jmybatis.agent.staticproxy.UserDao;
import com.jmybatis.agent.staticproxy.UserDao2;

/**
 * 测试类
 */
public class App {
    public static void main(String[] args) {
        errorEg();
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 class com.jmybatis.agent.staticproxy.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // class com.sun.proxy.$Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();

        System.out.println("%%%");
        System.out.println(proxy.getInfo());
    }


    /**
     * 思考 不用接口IUserDao，直接用UserDao创建代理。
     *
     *  实践后报错如下
     *  下面报错
     * Exception in thread "main"
     * java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.jmybatis.agent.staticproxy.UserDao2
     */

    public static void errorEg() {
        // 目标对象
//        IUserDao target = new UserDao();
        UserDao2 target = new UserDao2();
        // 【原始的类型 class com.jmybatis.agent.staticproxy.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        UserDao2 proxy = (UserDao2) new ProxyFactory(target).getProxyInstance();
        // class com.sun.proxy.$Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();

        System.out.println("%%%");
        System.out.println(proxy.getInfo());
    }

}
