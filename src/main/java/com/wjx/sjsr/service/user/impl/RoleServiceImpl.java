package com.wjx.sjsr.service.user.impl;

import com.wjx.sjsr.dao.user.RoleDAO;
import com.wjx.sjsr.model.user.Role;
import com.wjx.sjsr.service.user.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Resource
    private RoleDAO roleDAO;

    @Override
    public List<Role> findByUserid(Integer userId){
        return roleDAO.findByUserId(userId);
    }
}
