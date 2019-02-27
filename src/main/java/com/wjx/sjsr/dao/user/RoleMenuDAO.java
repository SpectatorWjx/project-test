package com.wjx.sjsr.dao.user;

import com.wjx.sjsr.dao.MyBatisBaseDao;
import com.wjx.sjsr.model.user.RoleMenu;
import org.springframework.stereotype.Component;

/**
 * RoleMenuDAO继承基类
 */
@Component
public interface RoleMenuDAO extends MyBatisBaseDao<RoleMenu, RoleMenu> {
}