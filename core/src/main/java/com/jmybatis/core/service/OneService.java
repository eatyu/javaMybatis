package com.jmybatis.core.service;

import com.jmybatis.core.dao.UserMapper;
import com.jmybatis.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneService {

    @Autowired
    private UserMapper userMapper;


    public User getOneUser() {
        return userMapper.selectOne(1);
    }

}
