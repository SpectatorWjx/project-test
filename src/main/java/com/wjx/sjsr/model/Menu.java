package com.wjx.sjsr.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_menu
 * @author 
 */
@Data
public class Menu implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;


    /**
     * 权限标识
     */
    private String permission;

    private static final long serialVersionUID = 1L;

}