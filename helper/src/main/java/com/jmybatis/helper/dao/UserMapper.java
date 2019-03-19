package com.jmybatis.helper.dao;

import com.jmybatis.helper.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectOne(int id);

    List<User> selectUsers();

}
