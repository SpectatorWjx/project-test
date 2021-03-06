package com.wjx.sjsr.service.test;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.Pair;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.entity.test.TestSearchEntity;
import com.wjx.sjsr.repository.TestSearchJpa;
import com.wjx.sjsr.service.jpa_abstract.AbstractServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/***
 * @classname: TestSearchSeaviceImpl
 * @description:
 * @author: wjx
 * @date: 2020/4/3 13:45
 */
@Service
@Slf4j
public class TestSearchServiceImpl extends AbstractServiceImpl<TestSearchEntity, TestSearchJpa> implements TestSearchService{

    @Autowired
    EntityManager entityManager;

    @Autowired
    TestSearchJpa testSearchJpa;

    @Override
    public List<TestSearchEntity> findByLikeKeyWord(String kw) {
        TestSearchEntity exampleEntity = new TestSearchEntity();
        exampleEntity.setSearch(kw);
        List<TestSearchEntity> list = findAllWhere(exampleEntity);
        return list;
    }


    @Override
    public List<TestSearchEntity> findBySearchKeyWord(String kw) {
        return search(kw);
    }

    @Override
//    @Transactional(rollbackFor = RuntimeException.class)
    public Result updateById(String id) {
        update(id);
        return new Result(ResultStatusCode.OK.getCode(),"success");
    }


//    @Transactional(rollbackFor = RuntimeException.class)
    public void update(String id){
        TestSearchEntity testSearchEntity = findById(id);
        testSearchEntity.setName("测试1");
        testSearchJpa.save(testSearchEntity);
        log.info("异常"+1/0);
    }

    @Override
    protected Pair<Boolean, Predicate> overrideSingleWhere(Map.Entry<String, ?> whereEntry,
                                                           Root<TestSearchEntity> root,
                                                           CriteriaBuilder cb) {
        if ("search".equals(whereEntry.getKey())) {
            String search = (String) whereEntry.getValue();
            if (!StringUtils.isEmpty(search)) {
                Predicate predicate = cb.like(root.get("testText").as(String.class), "%" + search + "%");
                //将memberCode根据逗号拆分
                return Pair.of(true, predicate);
            }
        }
        return Pair.of(false, null);
    }

    public List<TestSearchEntity> search(String term){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        fullTextEntityManager.createIndexer(TestSearchEntity.class).start();
        QueryBuilder builder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(TestSearchEntity.class).get();

        Query luceneQuery = builder
                .keyword()
                .fuzzy()
                .withEditDistanceUpTo(1)
                .onFields("testText")
                .matching(term).createQuery();

        FullTextQuery query = fullTextEntityManager.createFullTextQuery(luceneQuery, TestSearchEntity.class);
        List<TestSearchEntity> list = query.getResultList();
        return list;
    }
}
