package com.huanke.iot.base.persistence;

import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 数据Entity类
 *
 * @author onlymark
 * @create 2018-09-07 下午6:15
 */
@Data
public abstract class DataEntity  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    protected Date createTime;    // 创建日期
    protected Date updateTime;    // 更新日期
    protected int isDelete;    // 删除标记（0：正常；1：删除）

    public DataEntity() {
        super();
        this.isDelete = DEL_FLAG_NORMAL;
    }

    public DataEntity(Integer id) {
        super(id);
    }

}