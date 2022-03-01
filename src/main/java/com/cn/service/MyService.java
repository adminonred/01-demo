package com.cn.service;

import com.cn.model.User;

import java.util.List;

public interface MyService {
    List<User> select();
    boolean query(User user);
    boolean delete(int id);
    boolean update(int age,String name);
}
