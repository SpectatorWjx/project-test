package com.wjx.sjsr.service.test;

import com.wjx.sjsr.common.vo.Result;
import org.springframework.web.multipart.MultipartFile;

/***
 * @classname: TestUpYunService
 * @description:
 * @author: wjx
 * @date: 2020/4/13 16:26
 */
public interface TestUpYunService {
    /**
     * 上传图片
     * @param file
     * @return
     */
    Result upload(MultipartFile file);
}
