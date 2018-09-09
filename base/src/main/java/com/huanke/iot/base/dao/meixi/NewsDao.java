package com.huanke.iot.base.dao.meixi;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 * 新闻dao
 *
 * @author onlymark
 * @create 2018-09-07 下午3:46
 */
public interface NewsDao extends CrudDao<News> {
    List<News> getNewsList(@Param("beginNum") Integer beginNum, @Param("length") Integer length);
}
