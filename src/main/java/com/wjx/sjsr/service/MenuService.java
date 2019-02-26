package com.wjx.sjsr.service;

import com.wjx.sjsr.dao.MenuDAO;
import com.wjx.sjsr.model.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {
    @Resource
    private MenuDAO menuDAO;

    public List<Menu> getAllMenuByRoleId(Integer roleId){
        return menuDAO.getAllMenuByRoleId(roleId);
    }
}
