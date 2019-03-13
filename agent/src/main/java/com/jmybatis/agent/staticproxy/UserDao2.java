package com.jmybatis.agent.staticproxy;

public class UserDao2 {
    public boolean save() {
        System.out.println("userdao 2 save ......");
        return true;
    }

    public String getInfo() {
        return "userdao 2 get information ......";
    }
}
