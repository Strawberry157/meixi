package com.huanke.iot.base.dao;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 父mapper
 *
 * @author onlymark
 * @create 2018-09-07 下午2:24
 */
public interface MyBatisBaseDao<Model, PK extends Serializable, E> {
    long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(PK id);

    int insert(Model record);

    int insertSelective(Model record);

    List<Model> selectByExample(E example);

    Model selectByPrimaryKey(PK id);

    int updateByExampleSelective(@Param("record") Model record, @Param("example") E example);

    int updateByExample(@Param("record") Model record, @Param("example") E example);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);
}
