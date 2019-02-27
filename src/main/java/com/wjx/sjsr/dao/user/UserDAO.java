package com.wjx.sjsr.dao.user;

import com.wjx.sjsr.dao.MyBatisBaseDao;
import com.wjx.sjsr.model.user.User;
import org.springframework.stereotype.Component;

/**
 * UserDAO继承基类
 */
@Component
public interface UserDAO extends MyBatisBaseDao<User, Integer> {

    /**
     * 通过登录名获取帐号信息
     * @param name
     * @return
     */
    User getByName(String name);
}