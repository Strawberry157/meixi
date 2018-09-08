package com.huanke.iot.base.persistence;


import com.huanke.iot.base.service.Page;

import java.util.List;

/**
 * 描述:
 * DAO支持类实现
 *
 * @author onlymark
 * @create 2018-09-07 下午6:06
 */
public interface CrudDao<T> {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T get(Integer id);

    /**
     * 查询数据列表
     *
     * @param page
     * @return
     */
    List<T> findList(Page<T> page);

    /**
     * 查询数据条数
     *
     * @return
     */
    long count(Page<T> page);

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param id
     * @return
     * @see public int delete(T entity)
     */
    int delete(Integer id);
}
