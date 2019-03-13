package com.jmybatis.agent.staticproxy;

/**
 * 接口实现
 * 目标对象
 */
public class UserDao implements IUserDao {

    public boolean save() {
        System.out.println("save user information......");
        return true;
    }

    public String getInfo() {
        return "name is jerry";
    }
}
