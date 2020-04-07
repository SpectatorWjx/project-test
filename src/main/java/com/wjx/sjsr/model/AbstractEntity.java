package com.wjx.sjsr.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author wjx
 * @Date:2019/2/26
 * @Description:
 */
public class AbstractEntity implements Serializable{
    public static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Getter
    @Setter
    public Integer id;

    /**
     * 创建人
     */
    @Getter
    @Setter
    public String create_by;

    /**
     * 创建时间
     */
    @Getter
    @Setter
    public Date create_date;

    /**
     * 更新人
     */
    @Getter
    @Setter
    public String update_by;

    /**
     * 更新时间
     */
    @Getter
    @Setter
    public Date update_date;

    /**
     * 删除标记
     */
    @Getter
    @Setter
    private Integer delFlag;
}
