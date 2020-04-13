package com.wjx.sjsr.controller.test;

import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.service.test.TestUpYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/***
 * @classname: TestUpYunController
 * @description:
 * @author: wjx
 * @date: 2020/4/13 16:24
 */
@Controller
@RequestMapping("/upyun")
public class TestUpYunController {

    @Autowired
    TestUpYunService testUpYunService;

    @PostMapping("upload")
    @ResponseBody
    public Result uploadImage(MultipartFile file){
        return testUpYunService.upload(file);
    }
}
