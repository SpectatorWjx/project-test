package com.wjx.sjsr.model.user;

import com.wjx.sjsr.model.AbstractEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * sys_user_role
 * @author 
 */
@Data
public class UserRole extends AbstractEntity {
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