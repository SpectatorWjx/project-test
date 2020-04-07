package com.wjx.sjsr.vo;

import lombok.Data;

/***
 * @classname: SmsSendResultVo
 * @description:
 * @author: wjx zhijiu
 * @date: 2019/11/14 13:28
 */
@Data
public class SmsSendResultVo {
    private String reason;
    private Integer error_code;
    private Result result;
}

@Data
class Result{
    private String sid;
    private Integer fee;
    private Integer count;
}
