package com.wjx.sjsr.service.sms;

import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.param.RegParam;

/***
 * @classname: MsgSendService
 * @description:
 * @author: wjx zhijiu
 * @date: 2019/10/24 15:05
 */
public interface SmsSendService {
    Result sendRegisterSms(RegParam param);
}
