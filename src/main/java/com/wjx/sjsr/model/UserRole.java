package com.wjx.sjsr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role
 * @author 
 */
@Data
public class UserRole implements Serializable {
    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}