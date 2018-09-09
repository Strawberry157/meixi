package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.vo.UserAbilityLogVo;
import com.huanke.iot.base.dao.meixi.UserAbilityLogDao;
import com.huanke.iot.base.po.UserAbilityLog;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 能力service
 *
 * @author onlymark
 * @create 2018-09-09 下午7:14
 */
@Service
@Slf4j
public class UserAbilityService extends CrudService<UserAbilityLogDao, UserAbilityLog> {


    public List<UserAbilityLogVo> abilityLog(Integer userId, Date queryDate) {
        List<UserAbilityLogVo> userAbilityLogVoList = new ArrayList<>();
        List<UserAbilityLog> monthAbilityLog = dao.monthAbilityLog(userId, queryDate);
        for (UserAbilityLog userAbilityLog : monthAbilityLog) {
            UserAbilityLogVo userAbilityLogVo = new UserAbilityLogVo();
            userAbilityLogVo.setAbilityDate(userAbilityLog.getCreateTime());
            userAbilityLogVo.setAbilityValue(userAbilityLog.getSumValue());
            userAbilityLogVoList.add(userAbilityLogVo);
        }
        return userAbilityLogVoList;
    }
}
