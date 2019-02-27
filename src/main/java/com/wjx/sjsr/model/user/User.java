package com.wjx.sjsr.model.user;

import com.wjx.sjsr.model.AbstractEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_user
 * @author 
 */
@Data
public class User extends AbstractEntity {

    /**
     * 编号
     */
    public Integer id;

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

}