package com.wjx.sjsr.service.test;

import cn.hutool.core.lang.UUID;
import com.UpYun;
import com.upyun.FormUploader;
import com.upyun.Params;
import com.upyun.UpException;
import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.utils.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.upyun.CompressHandler.Params.BUCKET_NAME;

/***
 * @classname: TestUpYunServiceImpl
 * @description:
 * @author: wjx
 * @date: 2020/4/13 16:27
 */
@Service
public class TestUpYunServiceImpl implements TestUpYunService{

    private static String upyunUrl = "upyun.delpast.com";
    private static String filePath = "/uploads/";

    private static String bucket_name = "delpast-image";
    private static String operator = "spectator";
    private static String operator_key = "VoWLS0JZMs32qH43iMpHPV78Nuja2QyH";
    @Override
    public Result upload(MultipartFile file) {
        // 创建实例
        UpYun upyun = new UpYun(bucket_name, operator, operator_key);
        upyun.setDebug(false);
        upyun.setTimeout(30);

        // 定义保存路径
        String date = DateUtil.formatDateTime(new Date());
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String savePath = filePath + date + "/" + UUID.randomUUID()+"."+suffix;
        Boolean result = false;
        // 上传文件
        try {
             result = upyun.writeFile(savePath, file.getBytes(), true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UpException e) {
            e.printStackTrace();
        }
        if(!result){
            return new Result(ResultStatusCode.UPLOAD_ERROR);
        }
        String fileUrl = upyunUrl+savePath;
        return new Result(ResultStatusCode.OK,fileUrl);
    }
}
