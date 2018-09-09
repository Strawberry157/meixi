package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.vo.UserPointsSeqVo;
import com.huanke.iot.api.service.meixi.UserPointService;
import com.huanke.iot.base.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 用户积分controller
 *
 * @author onlymark
 * @create 2018-09-09 上午8:58
 */
@RestController
@RequestMapping("/meixi/points")
@Slf4j
public class UserPointsController extends BaseController {
    @Autowired
    private UserPointService userPointService;

    /**
     * 用户积分排行榜
     * @return
     */
    public Object getPointsSeq(){
        Integer userId = getCurrentUserId();
        log.info("用户积分排行榜，currentUserId={}", userId);
        UserPointsSeqVo userPointsSeqVo = userPointService.getPointsSeq(userId);
        return new ApiResponse<>();
    }
}
