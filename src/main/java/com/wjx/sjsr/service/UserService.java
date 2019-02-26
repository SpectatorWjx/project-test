package com.wjx.sjsr.service;

import com.wjx.sjsr.dao.UserDAO;
import com.wjx.sjsr.model.User;
import com.wjx.sjsr.common.vo.Grid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDAO userDAO;

    public Grid findList(){
        Grid grid = new Grid();

        Page page = PageHelper.offsetPage(0, 10, true);
        userDAO.findList(null);

        grid.setRows(page.getResult());
        grid.setTotal(page.getTotal());

        return grid;
    }

    public User getUserByName(String name){
        return userDAO.getByName(name);
    }
}
