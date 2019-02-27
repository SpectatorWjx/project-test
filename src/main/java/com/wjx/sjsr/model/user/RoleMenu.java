package com.wjx.sjsr.model.user;

import com.wjx.sjsr.model.AbstractEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * sys_role_menu
 * @author 
 */
@Data
public class RoleMenu extends AbstractEntity {

    /**
     * 编号
     */
    public Integer id;

    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 菜单编号
     */
    private Integer menuId;
}