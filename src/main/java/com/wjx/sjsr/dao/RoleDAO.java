package com.wjx.sjsr.dao;

import com.wjx.sjsr.model.Role;

import java.util.List;

/**
 * RoleDAO继承基类
 */
public interface RoleDAO extends MyBatisBaseDao<Role, Integer> {

    /**
     * 通过用户id获取用户拥有的角色
     * @param userId
     * @return
     */
    List<Role> findByUserId(Integer userId);
}