package com.wjx.sjsr.controller.test;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.entity.test.TestSearchEntity;
import com.wjx.sjsr.service.test.TestSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * @classname: TestSearchController
 * @description:
 * @author: wjx
 * @date: 2020/4/3 13:48
 */
@Controller
@RequestMapping("/test")
public class TestSearchController {

    @Autowired
    TestSearchService testSearchService;

    @ResponseBody
    @RequestMapping("/like")
    public Result getLike(String kw){
        List<TestSearchEntity> list = testSearchService.findByLikeKeyWord(kw);
        return new Result(ResultStatusCode.OK,list);
    }

    @ResponseBody
    @RequestMapping("/search")
    public Result getSearch(String kw){
        List<TestSearchEntity> list = testSearchService.findBySearchKeyWord(kw);
        return new Result(ResultStatusCode.OK,list);
    }
}
