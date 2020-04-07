package com.wjx.sjsr.controller;

import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.param.RegParam;
import com.wjx.sjsr.service.sms.SmsSendService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/***
 * @classname: MsgSendController
 * @description:
 * @author: wjx
 * @date: 2019/11/11 9:56
 */
@RequestMapping("sms")
@RestController
public class SmsSendController {
    @Autowired
    SmsSendService smsSendService;

    /**
     * 登陆注册验证码
     * @param param
     * @return
     */
//    @RequiresPermissions("INDEX")
    @PostMapping("/sendRegSms")
    public Result registerMsg(@RequestBody @Validated RegParam param){
        Result result = smsSendService.sendRegisterSms(param);
        return result;
    }
}
