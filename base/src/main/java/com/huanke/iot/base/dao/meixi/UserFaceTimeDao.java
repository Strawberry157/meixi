package com.huanke.iot.base.dao.meixi;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.po.UserFaceTime;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 *
 * @author onlymark
 * @create 2018-09-09 上午11:17
 */
public interface UserFaceTimeDao extends CrudDao<UserFaceTime> {
    List<UserFaceTime> monthFaceLog(@Param("userId") Integer userId, @Param("queryDate") Date queryDate);
}
