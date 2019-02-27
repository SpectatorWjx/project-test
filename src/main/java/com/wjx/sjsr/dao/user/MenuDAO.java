package com.wjx.sjsr.dao.user;

import com.wjx.sjsr.dao.MyBatisBaseDao;
import com.wjx.sjsr.model.user.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * MenuDAO继承基类
 */
@Component
public interface MenuDAO extends MyBatisBaseDao<Menu, Integer> {

    /**
     * 通过角色id获取所有权限信息
     * @param roleId
     * @return
     */
    List<Menu> getAllMenuByRoleId(Integer roleId);
}