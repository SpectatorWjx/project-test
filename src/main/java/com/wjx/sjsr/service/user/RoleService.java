package com.wjx.sjsr.service.user;

import com.wjx.sjsr.model.user.Role;

import java.util.List;

/**
 * @author wjx
 * @Date:2019/2/26
 * @Description:
 */
public interface RoleService {
    List<Role> findByUserid(Integer userId);
}
