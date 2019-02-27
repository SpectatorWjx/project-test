package com.wjx.sjsr.service.user;

import com.wjx.sjsr.model.user.Menu;

import java.util.List;

/**
 * @author wjx
 * @Date:2019/2/26
 * @Description:
 */
public interface MenuService {
    List<Menu> getAllMenuByRoleId(Integer roleId);
}
