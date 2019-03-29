package com.jmybatis.core.service;

import com.jmybatis.core.dao.UserMapper;
import com.jmybatis.core.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;


    public User getOneUser() {
        logger.info("%%%  getOneUser service");
        return userMapper.selectOne(1);
    }

    public List<User> getAllUser() {
        return userMapper.selectAll();
    }


}
