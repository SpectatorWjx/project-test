package com.wjx.sjsr.controller;

import com.wjx.sjsr.common.annotation.MyFirstAnnotation;
import com.wjx.sjsr.service.UserService;
import com.wjx.sjsr.common.vo.Grid;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("sys:user:view")
    @RequestMapping("/findList")
    public Grid findList(){
        return userService.findList();
    }

    @RequestMapping(value = "/say")
    public String sayHello() {
        System.out.println("吃饭");
        return "hello spring boot";
    }

}
