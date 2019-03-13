package com.jmybatis.agent.staticproxy;

/**
 * 代理对象，静态代理
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }


    public boolean save() {
        System.out.println("开始事务......");
        boolean isSave = target.save();
        System.out.println("提交事务......");
        return isSave;
    }

    public String getInfo() {
        return target.getInfo();
    }
}
