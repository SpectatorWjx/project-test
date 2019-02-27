package com.wjx.sjsr.model.user;

import com.wjx.sjsr.model.AbstractEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role
 * @author 
 */
@Data
public class Role extends AbstractEntity {

    /**
     * 编号
     */
    public Integer id;

    /**
     * 角色名称
     */
    private String name;


    /**
     * 角色类型
     */
    private Integer roleType;


    /**
     * 是否可用
     */
    private Integer useable;

}