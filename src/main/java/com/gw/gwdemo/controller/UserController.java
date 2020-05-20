package com.gw.gwdemo.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gw.gwdemo.entity.User;
import com.gw.gwdemo.service.UserService;
import com.gw.gwdemo.util.ResultMsg;
import com.gw.gwdemo.util.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

//@RestController
@Controller
@EnableSwagger2
@RequestMapping("/user")
@Api(tags = "用户相关",description = "test")
public class UserController {
    @Autowired
    private UserService userS;

    @ApiOperation("查找所有用户")
    @GetMapping("/findAllUser")
    @ResponseBody
    public ResultMsg findAll(HttpServletResponse response, HttpServletRequest request) {
        System.out.println(request.getHeaderNames());
        PageHelper.startPage(2,10);
        List<User> userList = userS.findAllUser();

        /* model.addAttribute("pageInfo", page);*/

        return ResultMsg.success("查询成功!").add("userList", userList);
    }

    @ApiOperation("查找所有用户")
    @GetMapping("/testfindAll")
    @ResponseBody
    public ResultMsg testfindAll(HttpServletResponse response, HttpServletRequest request) {
//        PageHelper.startPage(2,6);
        List<User> userList = userS.findAllUser();

        /* model.addAttribute("pageInfo", page);*/

        return ResultMsg.success("查询成功!").add("userList", userList);
    }

    @PostMapping("/findUser")
    @ResponseBody
    public ResultMsg findUser(User user, Model resultM){
        if (user.getUsername() == null){
            return ResultMsg.fail("失败");
        }
        User nUser = userS.findUser(user.getUsername());
        return ResultMsg.success("查询成功");
    }

    @PostMapping("/loginUser")
    public ResultMsg login(User user, Model resultM){
        if (user.getUsername() == null || user.getPassword() == null){
            return ResultMsg.fail("请输入账号和密码");
        }
        User us = userS.findUser(user.getUsername(),user.getPassword());
        if (us != null){
            return ResultMsg.success("登录成功");
        }
        return ResultMsg.fail("账号或密码错误");
    }

    @ApiOperation("注册账号")
    @PostMapping("/registerUser")
    @ResponseBody
    public ResultMsg registerUser(User user) {
        User nUser = userS.findUser(user.getUsername());
        if (nUser != null) {
            return ResultMsg.fail("用户已存在");
        }
        user.setRegtime(new Date());
        userS.addUser(user);
        return ResultMsg.success("注册成功");
    }


}
