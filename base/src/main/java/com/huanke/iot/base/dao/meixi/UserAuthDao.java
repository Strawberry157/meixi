package com.huanke.iot.base.dao.meixi;

import com.huanke.iot.base.persistence.CrudDao;
import com.huanke.iot.base.po.UserAuth;
import org.apache.ibatis.annotations.Param;

/**
 * 描述:
 * 用户授权dao
 *
 * @author onlymark
 * @create 2018-09-07 下午3:14
 */
public interface UserAuthDao extends CrudDao<UserAuth> {
    UserAuth getByIdentifier(@Param("identifier") String mobile);

    UserAuth verifyUser(@Param("identifier") String username, @Param("credential") String password);
}
