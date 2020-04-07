package com.wjx.sjsr.entity.test;

import com.wjx.sjsr.common.id_generator.TableIdPrefix;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import com.wjx.sjsr.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Table;

/***
 * @classname: TestSearchEntity
 * @description:
 * @author: wjx
 * @date: 2020/4/3 13:18
 */
@Data
@Entity
@Indexed(index = "post")
@Table(name = "test_search")
@TableIdPrefix("TESTSE")
@SQLDelete(sql = "update test_search set del_flag = 1 where id = ?")
@Where(clause = "del_flag = 0")
@Analyzer(impl=SmartChineseAnalyzer.class)
@org.hibernate.annotations.Table(appliesTo = "test_search",comment="饮食记录")
public class TestSearchEntity extends BaseEntity {
    @Field
    private String name;

    @Field
    private String testText;
}
