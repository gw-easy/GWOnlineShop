package com.gw.gwdemo.service;

import com.gw.gwdemo.entity.User;
import com.gw.gwdemo.util.page.PageRequest;
import com.gw.gwdemo.util.page.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<User> findAllUser();

    void addUser(User user);

    User findUser(String name);

    User findUser(String username,String password);

    PageResult findPage(PageRequest pageRequest);
}
