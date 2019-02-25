package com.alex.springboot.controller;

import com.alex.springboot.system.enums.ResultStatusCode;
import com.alex.springboot.system.vo.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @RequestMapping("/login")
    public Result login(String loginName, String pwd){
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, pwd);
            //登录不在该处处理，交由shiro处理
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            if (subject.isAuthenticated()) {
                JSON json = new JSONObject();
                ((JSONObject) json).put("token", subject.getSession().getId());

                return new Result(ResultStatusCode.OK, json);
            }else{
                return new Result(ResultStatusCode.SHIRO_ERROR);
            }
        }catch (IncorrectCredentialsException | UnknownAccountException e){
            return new Result(ResultStatusCode.NOT_EXIST_USER_OR_ERROR_PWD);
        }catch (LockedAccountException e){
            return new Result(ResultStatusCode.USER_FROZEN);
        }catch (Exception e){
            return new Result(ResultStatusCode.SYSTEM_ERR);
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.OK);
    }
}
