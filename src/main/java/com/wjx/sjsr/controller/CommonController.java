package com.wjx.sjsr.controller;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @RequestMapping("/login")
    public Result login(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.NO_LOGIN);
    }

    /**
     * 未授权跳转方法
     * @return
     */
    @RequestMapping("/unauth")
    public Result unauth(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.UNAUTHO_ERROR);
    }

    /**
     * 被踢出后跳转方法
     * @return
     */
    @RequestMapping("/kickout")
    public Result kickout(){
        return new Result(ResultStatusCode.INVALID_TOKEN);
    }

}
