package com.gw.gwdemo.service;

import com.gw.gwdemo.dao.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findAllUser();
}
