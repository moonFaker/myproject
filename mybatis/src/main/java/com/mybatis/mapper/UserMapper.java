package com.mybatis.mapper;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {


    @Select("select * from user")
    public List<User> getAll();


    @Select("select * from user where id=#{userId}")
    public User getById(String userId);


    @Update("update user set name=#{name} where id=#{userId}")
    public int updateById(@Param("userId") String userId, @Param("name") String name);
}
