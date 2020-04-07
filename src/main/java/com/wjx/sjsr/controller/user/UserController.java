package com.wjx.sjsr.controller.user;

import com.wjx.sjsr.common.vo.Grid;
import com.wjx.sjsr.service.user.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("INDEX")
    @RequestMapping("/findList")
    public Grid findList(){
        return userService.findList();
    }


}
