package com.gw.gwdemo.service.impl;

import com.gw.gwdemo.dao.User;
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
        return userM.findAllUser();
    }
}
