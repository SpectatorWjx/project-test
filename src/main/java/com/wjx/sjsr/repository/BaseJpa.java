package com.wjx.sjsr.repository;

import com.wjx.sjsr.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/***
 * @classname: UserJpa
 * @description:
 * @author: wjx zhijiu
 * @date: 2019/10/8 10:59
 */
public interface BaseJpa<Entity extends BaseEntity> extends JpaRepository<Entity , String>, JpaSpecificationExecutor {
}
