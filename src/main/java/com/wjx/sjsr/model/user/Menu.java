package com.wjx.sjsr.model.user;

import com.wjx.sjsr.model.AbstractEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_menu
 * @author 
 */
@Data
public class Menu extends AbstractEntity {

    /**
     * 名称
     */
    private String name;


    /**
     * 权限标识
     */
    private String permission;

}