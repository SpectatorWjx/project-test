package com.wjx.sjsr.service.sms;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.param.RegParam;
import com.wjx.sjsr.utils.sms.AliYunSmsUtil;
import com.wjx.sjsr.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/***
 * @classname: MsgSendServiceImpl
 * @description:
 * @author: wjx zhijiu
 * @date: 2019/10/24 15:05
 */
@Service
@Slf4j
public class SmsSendServiceImpl implements SmsSendService {
    private Integer expirationSeconds = 3600;

    /**
    *短信发送时间间隔（秒）
     */
    private static Integer SEND_INTERVAL = 60;
    private static final String SUCCESS_CODE = "OK";

    @Autowired
    RedisUtil redisUtil;


    @Override
    public Result sendRegisterSms(RegParam param) {
        String phone = param.getPhone();
        String code = smsSendSuccess(phone);
        if(!StringUtils.isEmpty(code)){
            log.info("验证码发送成功");
            redisUtil.setLoginSms(phone, code, expirationSeconds, SEND_INTERVAL);
            return new Result(200, "OK");
        }
        return new Result(500,"服务器错误，验证码发送失败");
    }

    private String smsSendSuccess(String phone){
        if(StringUtils.isBlank(phone)){
            log.info("手机号不能为空");
            throw new RuntimeException("手机号不能为空");
        }

        Boolean oneMinuteIsSend = redisUtil.isJustSend(phone);
        if(oneMinuteIsSend){
            log.info("验证码发送频繁");
            throw new RuntimeException("验证码发送频繁, 一分钟内只能发送一次");
        }

        Long count = redisUtil.smsOneDaySendCount(phone);
        if(count > 2){
            log.info("验证码发送频繁,超过了限定的次数");
            throw new RuntimeException("验证码发送频繁,超过了当天限定次数");
        }

        String code = String.valueOf((int)((Math.random()*9+1)*100000));

        SendSmsResponse sendSms = AliYunSmsUtil.sendSms(phone, code);
        Optional.ofNullable(sendSms).orElseThrow(() ->
                new RuntimeException("服务器错误，验证码发送失败"));

        if(sendSms.getCode()!= null && sendSms.getCode().equals(SUCCESS_CODE)){
            return code;
        } else {
            log.error("短信接口返回的数据----------------");
            log.error("Code=" + sendSms.getCode() + " " + "Message=" + sendSms.getMessage());
            return "";
        }
/*        //聚合数据短信发送
        SmsSendResultVo vo = MsgJuHeSendUtil.mobileQuery(phone,code);
        if(vo.getError_code()==0 && vo.getReason().equals("操作成功")){
            return code;
        }
        log.error(vo.toString());
 */

    }
}
