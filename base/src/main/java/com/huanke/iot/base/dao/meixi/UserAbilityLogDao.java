package com.huanke.iot.base.dao.meixi;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.po.UserAbilityLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 描述:
 * 用户能力日志dao
 *
 * @author onlymark
 * @create 2018-09-07 下午3:55
 */
public interface UserAbilityLogDao extends CrudDao<UserAbilityLog> {

    List<UserAbilityLog> monthAbilityLog(@Param("userId") Integer userId, @Param("queryDate") Date queryDate);
}
