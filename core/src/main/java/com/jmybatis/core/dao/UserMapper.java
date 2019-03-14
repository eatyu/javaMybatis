package com.jmybatis.core.dao;

import com.jmybatis.core.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectOne(int id);

}
