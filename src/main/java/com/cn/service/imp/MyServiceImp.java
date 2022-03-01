package com.cn.service.imp;

import com.cn.dao.UserDao;
import com.cn.model.User;
import com.cn.service.MyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyServiceImp implements MyService {
    @Resource
    UserDao userDao;
    @Override
    public List<User> select() {
        return userDao.select();
    }

    @Override
    public boolean query(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }
    @Override
    public boolean update(int age, String name) {
        boolean flag=false;
        flag=userDao.update(age,name);
        return flag;
    }

}
