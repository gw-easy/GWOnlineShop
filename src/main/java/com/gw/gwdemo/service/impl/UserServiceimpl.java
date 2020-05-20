package com.gw.gwdemo.service.impl;

import com.gw.gwdemo.entity.User;
import com.gw.gwdemo.entity.UserExample;
import com.gw.gwdemo.mapper.UserMapper;
import com.gw.gwdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceimpl implements UserService {
    @Autowired(required = false)
    private UserMapper userM;

    @Override
    public List<User> findAllUser() {
        return userM.selectByExample(new UserExample());
    }

    @Override
    public void addUser(User user) {
        int us = userM.insertSelective(user);
    }

    @Override
    public User findUser(String name) {
        UserExample userE = new UserExample();
        UserExample.Criteria cir =  userE.createCriteria();
        cir.andUsernameEqualTo(name);
        List<User> listU = userM.selectByExample(userE);
        return listU.size()>0?listU.get(0):null;
    }

    @Override
    public User findUser(String username, String password) {
        UserExample userE = new UserExample();
        UserExample.Criteria cir =  userE.createCriteria();
        cir.andUsernameEqualTo(username);
        cir.andPasswordEqualTo(password);
        List<User> listU = userM.selectByExample(userE);
        return listU.size()>0?listU.get(0):null;
    }
}
