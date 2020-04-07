package com.wjx.sjsr.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @classname: RegParam
 * @description:
 * @author: wjx zhijiu
 * @date: 2019/11/26 9:55
 */
@Data
public class RegParam {
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
