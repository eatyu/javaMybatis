package com.jmybatis.helper.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmybatis.helper.dao.UserMapper;
import com.jmybatis.helper.entity.User;
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

    public List<User> getUsers() {
        PageHelper.startPage(3,2);
        List<User> users = userMapper.selectUsers();


        //得到分页的结果对象
        PageInfo<User> personPageInfo = new PageInfo<>(users);
        //得到分页中的person条目对象
        List<User> pageList = personPageInfo.getList();

        return pageList;
    }
}
