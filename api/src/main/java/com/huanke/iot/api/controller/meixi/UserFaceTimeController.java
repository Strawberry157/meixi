package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.AbilityLogRequest;
import com.huanke.iot.api.controller.meixi.vo.UserFaceTimeVo;
import com.huanke.iot.api.service.meixi.UserFaceTimeService;
import com.huanke.iot.base.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 使用记录controller
 *
 * @author onlymark
 * @create 2018-09-09 上午11:24
 */
@RestController
@RequestMapping("/meixi/facetime")
@Slf4j
public class UserFaceTimeController extends BaseController{
    @Autowired
    private UserFaceTimeService userFaceTimeService;

    @RequestMapping("/log")
    public Object logFaceTime(){
        Integer userId = getCurrentUserId();
        Date logDate = new Date();
        log.info("记录使用记录：userId={}, logDate={}", userId, logDate);
        userFaceTimeService.logFaceTime(userId, logDate);
        return new ApiResponse<>();
    }

    /**
     * 获取能力统计
     * @return
     */
    @RequestMapping("/faceTimeLog")
    public Object abilityLog(@Valid @RequestBody AbilityLogRequest request){
        Integer userId = getCurrentUserId();
        Date queryDate = request.getQueryDate();
        log.info("获取护肤记录：userId={}, queryDate={}", userId, queryDate);
        List<UserFaceTimeVo> monthFaceLogs = userFaceTimeService.monthFaceLog(userId, queryDate);
        return new ApiResponse<>(monthFaceLogs);
    }
}
