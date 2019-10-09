package com.xg.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xg.dao.UserDao;
import com.xg.entity.User;
import com.xg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
//  private  UserDao userDao;

    @Override
    public List<User> getAllUser() {
//        EntityWrapper<User> wrapper = new EntityWrapper<>();
//        wrapper.eq("uname",1);
//        List<User> list1 = userDao.selectList(null);
//        List<User> list = userDao.selectList(wrapper);
        List<User> list = new ArrayList<>();
        return list;
    }
}
