package com.huanke.iot.base.dao.meixi;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.po.UserPoint;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:
 * 用户积分dao
 *
 * @author onlymark
 * @create 2018-09-07 下午4:07
 */
public interface UserPointDao extends CrudDao<UserPoint> {
    UserPoint getByUserId(@Param("userId") Integer userId);
}
