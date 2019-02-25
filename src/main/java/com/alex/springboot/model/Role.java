package com.alex.springboot.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_role
 * @author 
 */
@Data
public class Role implements Serializable {
    /**
     * 编号
     */
    private Integer id;

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

    private static final long serialVersionUID = 1L;

}