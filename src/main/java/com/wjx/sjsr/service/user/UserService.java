package com.wjx.sjsr.service.user;

import com.wjx.sjsr.common.vo.Grid;
import com.wjx.sjsr.model.user.User;

/**
 * @author wjx
 * @Date:2019/2/26
 * @Description:
 */
public interface UserService {
    Grid findList();
    User getUserByName(String name);
}
