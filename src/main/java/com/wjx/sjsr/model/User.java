package com.wjx.sjsr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;


    /**
     * 工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;


    /**
     * 电话
     */
    private String phone;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    private static final long serialVersionUID = 1L;

}