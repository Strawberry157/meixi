package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.BaseRequest;
import com.huanke.iot.api.controller.meixi.request.NewsListRequest;
import com.huanke.iot.api.controller.meixi.vo.NewsListItemVo;
import com.huanke.iot.api.controller.meixi.vo.NewsVo;
import com.huanke.iot.api.service.meixi.NewsService;
import com.huanke.iot.base.api.ApiResponse;
import com.huanke.iot.base.po.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 描述:
 * 新闻资讯controller
 *
 * @author onlymark
 * @create 2018-09-09 上午9:53
 */
@RestController
@RequestMapping("/meixi/news")
@Slf4j
public class NewsController extends BaseController{
    @Autowired
    private NewsService newsService;

    /**
     * 新闻资讯列表
     * @param request
     * @return
     */
    @RequestMapping("/newsList")
    public Object newsList(@Valid @RequestBody NewsListRequest request){
        Integer beginNum = request.getBeginNum();
        Integer length = request.getLength();
        log.info("新闻资讯列表，userId={}, beginNum={}, length={}", getCurrentUserId(), beginNum, length);
        List<NewsListItemVo> newsListItemVoList = newsService.getNewsList(beginNum, length);
        return new ApiResponse<>(newsListItemVoList);
    }

    /**
     * 新闻内容
     * @param request
     * @return
     */
    @RequestMapping("/content")
    public Object getContent(@Valid @RequestBody BaseRequest request){
        Integer newsId = (Integer) request.getValue();
        log.info("新闻内容，userId={}, newsId={}", getCurrentUserId(), newsId);
        News news = newsService.get(newsId);
        NewsVo newsVo = new NewsVo();
        BeanUtils.copyProperties(news, newsVo);
        return new ApiResponse<>(newsVo);
    }
}
