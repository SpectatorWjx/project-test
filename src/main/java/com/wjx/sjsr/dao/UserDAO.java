package com.wjx.sjsr.dao;

import com.wjx.sjsr.model.User;

/**
 * UserDAO继承基类
 */
public interface UserDAO extends MyBatisBaseDao<User, Integer> {

    /**
     * 通过登录名获取帐号信息
     * @param name
     * @return
     */
    User getByName(String name);
}