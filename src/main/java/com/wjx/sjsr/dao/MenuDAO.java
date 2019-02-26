package com.wjx.sjsr.dao;

import com.wjx.sjsr.model.Menu;

import java.util.List;

/**
 * MenuDAO继承基类
 */
public interface MenuDAO extends MyBatisBaseDao<Menu, Integer> {

    /**
     * 通过角色id获取所有权限信息
     * @param roleId
     * @return
     */
    List<Menu> getAllMenuByRoleId(Integer roleId);
}