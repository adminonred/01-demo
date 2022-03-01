package com.cn.dao;

import com.cn.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    boolean insert(User user);
    List<User> select();
    boolean delete(int id);
    boolean update(int age,String name);
}
