package com.wjx.sjsr.model.user;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role
 * @author 
 */
@Data
public class UserRole implements Serializable {

    public static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    public Integer id;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private Integer roleId;
}