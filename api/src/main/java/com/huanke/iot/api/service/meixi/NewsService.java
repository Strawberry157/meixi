package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.vo.NewsListItemVo;
import com.huanke.iot.base.dao.meixi.NewsDao;
import com.huanke.iot.base.po.News;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 新闻资讯service
 *
 * @author onlymark
 * @create 2018-09-09 上午9:54
 */
@Service
@Slf4j
public class NewsService extends CrudService<NewsDao, News> {

    public List<NewsListItemVo> getNewsList(Integer beginNum, Integer length) {
        List<NewsListItemVo> newsListItemVoList = new ArrayList<>();
        List<News> newsList = dao.getNewsList(beginNum, length);
        for (News news : newsList) {
            NewsListItemVo newsListItemVo = new NewsListItemVo();
            BeanUtils.copyProperties(news, newsListItemVo);
            newsListItemVoList.add(newsListItemVo);
        }
        return newsListItemVoList;
    }
}
