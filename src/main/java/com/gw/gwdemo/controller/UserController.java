package com.gw.gwdemo.controller;


import com.github.pagehelper.PageInfo;
import com.gw.gwdemo.dao.User;
import com.gw.gwdemo.service.UserService;
import com.gw.gwdemo.util.ResultMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

//@RestController
@Controller
@EnableSwagger2
@RequestMapping("/user")
@Api(tags = "用户相关",description = "test")
public class UserController {
    @Autowired
    private UserService userS;

    @ApiOperation("发现所有用户")
    @RequestMapping("/findAllUser")
    @ResponseBody
    public ResultMsg findAll(){
        List<User> userList = userS.findAllUser();

        /* model.addAttribute("pageInfo", page);*/

        return ResultMsg.success("查询成功!").add("userList", userList);
    }
}
