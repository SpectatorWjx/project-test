package com.wjx.sjsr.model.seckill;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wjx
 * 秒杀订单表（秒杀订单表和其他订单表不同，属于独立的模块）
 *
 */
public class TestSeckillOrder implements Serializable {

    /**
     * id
     */
    @Getter
    @Setter
    public Integer id;

    /**
     *秒杀到的商品ID
     */
    private long seckillId;

    /**
     *支付金额
     */
    private BigDecimal money;


    /**
     *秒杀用户的手机号
     */
    private long userPhone;

    /**
     *创建时间
     */

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    /**
     *订单状态， -1:无效 0:成功 1:已付款
     */
    private boolean status;

    /**
     *秒杀商品，和订单是一对多的关系
     */
    private TestSeckill seckill;

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public TestSeckill getSeckill() {
        return seckill;
    }

    public void setSeckill(TestSeckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SeckillOrder{" +
                "seckillId=" + seckillId +
                ", money=" + money +
                ", createTime=" + createTime +
                ", status=" + status +
                ", seckill=" + seckill +
                '}';
    }
}
