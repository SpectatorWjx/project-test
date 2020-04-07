package com.wjx.sjsr.controller.qr;

import com.wjx.sjsr.utils.qr.QRCodeUtil;
import com.google.zxing.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二维码调用前端控制器
 */
@RequestMapping("/Qrcode")
@RestController
public class QrcodeController {

    /**
     * 生成二维码
     */
    @GetMapping("create")
    public void productcode() {
        QRCodeUtil.zxingCodeCreate("辣鸡", "D:/test/",500,"D:/test/11.jpg");
    }


    /**
     * 解析二维码
     */
    @GetMapping("/test")
    public void analysiscode() {
        Result result = QRCodeUtil.zxingCodeAnalyze("D:/voice/picture/2018/759.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }

}