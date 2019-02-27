package com.wjx.sjsr.service.user.impl;

import com.wjx.sjsr.dao.user.UserDAO;
import com.wjx.sjsr.model.user.User;
import com.wjx.sjsr.common.vo.Grid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjx.sjsr.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public Grid findList(){
        Grid grid = new Grid();

        Page page = PageHelper.offsetPage(0, 10, true);
        userDAO.findList(null);

        grid.setRows(page.getResult());
        grid.setTotal(page.getTotal());

        return grid;
    }

    @Override
    public User getUserByName(String name){
        return userDAO.getByName(name);
    }
}
