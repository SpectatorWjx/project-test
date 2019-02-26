package com.wjx.sjsr.model;

import lombok.Data;

import java.io.Serializable;

/**
 * sys_role_menu
 * @author 
 */
@Data
public class RoleMenu implements Serializable {
    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 菜单编号
     */
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}