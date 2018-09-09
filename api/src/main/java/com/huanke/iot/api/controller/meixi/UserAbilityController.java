package com.huanke.iot.api.controller.meixi;

import com.huanke.iot.api.controller.meixi.request.AbilityLogRequest;
import com.huanke.iot.api.controller.meixi.vo.UserAbilityLogVo;
import com.huanke.iot.api.service.meixi.UserAbilityService;
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
 * 能力controller
 *
 * @author onlymark
 * @create 2018-09-09 下午7:13
 */
@RestController
@RequestMapping("/meixi/points")
@Slf4j
public class UserAbilityController extends BaseController{
    @Autowired
    private UserAbilityService userAbilityService;

    /**
     * 获取能力统计
     * @return
     */
    @RequestMapping("/abilityLog")
    public Object abilityLog(@Valid @RequestBody AbilityLogRequest request){
        Integer userId = getCurrentUserId();
        Date queryDate = request.getQueryDate();
        log.info("能力记录值：userId={}, queryDate={}", userId, queryDate);
        List<UserAbilityLogVo> monthAbilityLogs = userAbilityService.abilityLog(userId, queryDate);
        return new ApiResponse<>(monthAbilityLogs);
    }
}
