package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.vo.UserFaceTimeVo;
import com.huanke.iot.base.dao.meixi.UserFaceTimeDao;
import com.huanke.iot.base.po.UserFaceTime;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author onlymark
 * @create 2018-09-09 上午11:25
 */
@Service
@Slf4j
public class UserFaceTimeService extends CrudService<UserFaceTimeDao, UserFaceTime> {

    public void logFaceTime(Integer userId, Date logDate) {
        UserFaceTime userFaceTime = new UserFaceTime();
        userFaceTime.setUserId(userId);
        userFaceTime.setFaceTime(logDate);
        save(userFaceTime);
    }

    public List<UserFaceTimeVo> monthFaceLog(Integer userId, Date queryDate) {
        List<UserFaceTimeVo> userFaceTimeVoList = new ArrayList<>();
        List<UserFaceTime> userFaceTimeList = dao.monthFaceLog(userId, queryDate);
        for (UserFaceTime userFaceTime : userFaceTimeList) {
            UserFaceTimeVo userFaceTimeVo = new UserFaceTimeVo();
            userFaceTimeVo.setFaceDate(userFaceTime.getFaceTime());
            userFaceTimeVoList.add(userFaceTimeVo);
        }
        return userFaceTimeVoList;
    }
}
