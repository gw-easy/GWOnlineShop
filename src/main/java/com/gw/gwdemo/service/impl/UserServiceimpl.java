package com.gw.gwdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.gwdemo.entity.User;
import com.gw.gwdemo.entity.UserExample;
import com.gw.gwdemo.mapper.UserMapper;
import com.gw.gwdemo.service.UserService;
import com.gw.gwdemo.util.page.PageRequest;
import com.gw.gwdemo.util.page.PageResult;
import com.gw.gwdemo.util.page.PageUtils;
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

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userM.selectByExample(new UserExample());
        return new PageInfo<User>(sysMenus);
    }
}
