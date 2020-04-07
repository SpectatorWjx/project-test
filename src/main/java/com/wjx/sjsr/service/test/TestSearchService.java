package com.wjx.sjsr.service.test;

import com.wjx.sjsr.entity.test.TestSearchEntity;
import com.wjx.sjsr.service.jpa_abstract.AbstractService;

import java.util.List;

/***
 * @classname: TestSearchService
 * @description:
 * @author: wjx
 * @date: 2020/4/3 13:44
 */
public interface TestSearchService extends AbstractService<TestSearchEntity> {
    /**
     * 根据关键字模糊查询
     * @param kw
     * @return
     */
    List<TestSearchEntity> findByLikeKeyWord(String kw);

    /**
     * 根据关键字lucene查询
     * @param kw
     * @return
     */
    List<TestSearchEntity> findBySearchKeyWord(String kw);
}
