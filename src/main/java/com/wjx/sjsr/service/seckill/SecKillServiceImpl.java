package com.wjx.sjsr.service.seckill;

import com.wjx.sjsr.common.enums.ResultStatusCode;
import com.wjx.sjsr.common.vo.BaseException;
import com.wjx.sjsr.common.vo.Result;
import com.wjx.sjsr.dao.seckill.TestSeckillDAO;
import com.wjx.sjsr.dao.seckill.TestSeckillOrderDAO;
import com.wjx.sjsr.model.seckill.TestSeckill;
import com.wjx.sjsr.model.seckill.TestSeckillOrder;
import com.wjx.sjsr.model.user.User;
import com.wjx.sjsr.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wjx
 * 1027-12-14
 */
@Service
@Slf4j
public class SecKillServiceImpl implements SecKillService {

    private final String key = "seckill";

    @Autowired(required = false)
    private TestSeckillDAO seckillMapper;

    @Autowired(required = false)
    private TestSeckillOrderDAO seckillOrderMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 超时时间 10秒
     */
    private static final int TIMEOUT = 10;

    /**
     * 超时时间 10秒
     */
    private static final int TIME_RETRY = 10;


    @Override
    public Result querySecKillProductInfo(Long productId) {
        TestSeckill testSeckill = (TestSeckill) redisUtil.getCache(key, String.valueOf(productId));
        if (testSeckill == null || testSeckill.getStockCount()<=0){
            //查询数据库中数据，并将数据redis缓存中
            testSeckill = seckillMapper.findById(productId);
            if(testSeckill.getStockCount()>0) {
                redisUtil.setCache(key, String.valueOf(productId), testSeckill);
                log.info("findAll -> 从数据库中读取放入缓存中");
            }
        } else {
            log.info("findAll -> 从缓存中读取");
        }
        return new Result(ResultStatusCode.OK.getCode(), "success", testSeckill);
    }

    /**
     * 描述逻辑
     *
     * @param productId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result orderProductMockDiffUser(Long productId) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Date nowTime = new Date();

        TestSeckill seckill = (TestSeckill) redisUtil.getCache(key, String.valueOf(productId));
        if (seckill == null || seckill.getStockCount() <= 0) {
            //没有更新记录，秒杀结束
            throw new BaseException("活动已经结束");
        }
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT * 1000;
        if (!redisUtil.lock(String.valueOf(productId), String.valueOf(time))) {
            throw new BaseException(ResultStatusCode.OK.getCode(), "当前人数太多，刷新重试");
        }

        int insertCount = seckillOrderMapper.insertOrder(productId, new BigDecimal(55), Long.valueOf(user.getPhone()));
        if (insertCount <= 0) {
            //重复秒杀 设置联合主键（当前已取消）
            throw new BaseException("你已参与活动");
        }
        int updateCount = seckillMapper.reduceStock(productId, nowTime);
        if (updateCount <= 0) {
            //库存不足
            throw new BaseException(ResultStatusCode.OK.getCode(), "活动已经结束2");
        }
        //秒杀成功
        //更新缓存(更新库存数量)
        seckill.setStockCount(seckill.getStockCount() - 1);
        redisUtil.setCache(key, String.valueOf(productId), seckill);
        //解锁
        redisUtil.unlock(String.valueOf(productId), String.valueOf(time));
        return new Result(ResultStatusCode.OK.getCode(), "success", "秒杀成功");
    }
}