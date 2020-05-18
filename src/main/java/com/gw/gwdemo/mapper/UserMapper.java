package com.gw.gwdemo.mapper;

import com.gw.gwdemo.dao.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
