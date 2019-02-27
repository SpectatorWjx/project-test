package com.wjx.sjsr.dao.user;

import com.wjx.sjsr.dao.MyBatisBaseDao;
import com.wjx.sjsr.model.user.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RoleDAO继承基类
 */
@Component
public interface RoleDAO extends MyBatisBaseDao<Role, Integer> {

    /**
     * 通过用户id获取用户拥有的角色
     * @param userId
     * @return
     */
    List<Role> findByUserId(Integer userId);
}