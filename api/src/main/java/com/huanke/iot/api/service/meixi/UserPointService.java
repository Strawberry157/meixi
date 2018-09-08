package com.huanke.iot.api.service.meixi;

import com.huanke.iot.base.dao.meixi.UserPointDao;
import com.huanke.iot.base.po.UserPoint;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.huanke.iot.base.persistence.BaseEntity.DEL_FLAG_NORMAL;

/**
 * 描述:
 * 用户积分service
 *
 * @author onlymark
 * @create 2018-09-08 下午4:04
 */
@Service
@Slf4j
public class UserPointService extends CrudService<UserPointDao, UserPoint> {
    @Override
    protected void preInsert(UserPoint userPoint) {
        userPoint.setIsDelete(DEL_FLAG_NORMAL);
        if (userPoint.getCreateTime() == null) {
            userPoint.setCreateTime(new Date());
        }
        userPoint.setPoints(0);
        userPoint.setIncrMulti(1.0);
    }

    public UserPoint getByUserId(Integer userId) {
        return dao.getByUserId(userId);
    }
}
