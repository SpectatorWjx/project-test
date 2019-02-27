package com.wjx.sjsr.service.user.impl;

import com.wjx.sjsr.dao.user.MenuDAO;
import com.wjx.sjsr.model.user.Menu;
import com.wjx.sjsr.service.user.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuDAO menuDAO;

    @Override
    public List<Menu> getAllMenuByRoleId(Integer roleId){
        return menuDAO.getAllMenuByRoleId(roleId);
    }
}
