package com.wjx.sjsr.service;

import com.wjx.sjsr.dao.RoleDAO;
import com.wjx.sjsr.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    private RoleDAO roleDAO;

    public List<Role> findByUserid(Integer userId){
        return roleDAO.findByUserId(userId);
    }
}
