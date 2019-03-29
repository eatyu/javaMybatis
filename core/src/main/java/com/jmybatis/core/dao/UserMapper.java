package com.jmybatis.core.dao;

import com.jmybatis.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectOne(int id);

    List<User> selectAll();

}
