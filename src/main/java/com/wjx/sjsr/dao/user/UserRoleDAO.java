package com.wjx.sjsr.dao.user;

import com.wjx.sjsr.dao.MyBatisBaseDao;
import com.wjx.sjsr.model.user.UserRole;
import org.springframework.stereotype.Component;

/**
 * UserRoleDAO继承基类
 */
@Component
public interface UserRoleDAO extends MyBatisBaseDao<UserRole, UserRole> {
}