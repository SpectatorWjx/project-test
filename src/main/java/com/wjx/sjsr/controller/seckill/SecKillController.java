package com.wjx.sjsr.controller.seckill;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.BaseException;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.service.seckill.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 86186
 */
@RestController
@RequestMapping("/skill")
@Slf4j
public class SecKillController {

    @Autowired
    private SecKillService secKillService;



    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    @GetMapping("/query/{productId}")
    public Result query(@PathVariable Long productId)throws Exception
    {
        return secKillService.querySecKillProductInfo(productId);
    }


    /**
     * 秒杀，没有抢到获得"哎呦喂,xxxxx",抢到了会返回剩余的库存量
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/order/{productId}")
    public Result skill(@PathVariable Long productId)
    {
        return secKillService.orderProductMockDiffUser(productId);
    }
}