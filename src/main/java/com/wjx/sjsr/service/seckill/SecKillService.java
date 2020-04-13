package com.wjx.sjsr.service.seckill;

import com.wjx.sjsr.common.vo.Result;

/**
 * @author wjx
 * 2019-12-14
 */
public interface SecKillService {
    /**
     * 查询秒杀活动特价商品的信息
     *
     * @param productId
     * @return
     */
    Result querySecKillProductInfo(Long productId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     *
     * @param productId
     * @return
     */
    Result orderProductMockDiffUser(Long productId);
}