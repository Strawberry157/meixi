package com.huanke.iot.api.service.meixi;

import com.huanke.iot.base.api.ApiResponse;
import com.huanke.iot.base.constant.RetCode;
import com.huanke.iot.base.constant.UserConstants;
import com.huanke.iot.base.constant.UserLevelTypeConstants;
import com.huanke.iot.base.constant.UserRegisterConstants;
import com.huanke.iot.base.dao.meixi.UserAuthDao;
import com.huanke.iot.base.po.User;
import com.huanke.iot.base.po.UserAuth;
import com.huanke.iot.base.po.UserPoint;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * 用户授权Service
 *
 * @author onlymark
 * @create 2018-09-08 上午8:42
 */
@Service
@Slf4j
public class UserAuthService extends CrudService<UserAuthDao, UserAuth> {
    @Autowired
    private UserService userService;
    @Autowired
    private UserPointService userPointService;
    /**
     * 发送验证码
     * @param mobile
     * @return
     */
    public Object sendVerifyCode(String mobile) {
        // 判断发送给客户端的短信是否发送成功
        try {
            // 1.验证用户名是否重复
            UserAuth userAuth = getByIdentifier(mobile);
            // 如果用户已经存在
            if (userAuth != null) {
                return new ApiResponse<>(RetCode.ERROR,"用户已经存在");
            }
            //发短信
            //smsHander.sendVerifyCode(UicConstants.SMS_CODE_TYPE_REGISTER,phone);
        } catch (Exception e) {
            e.printStackTrace();
            ApiResponse apiResponse = ApiResponse.responseError(e);
        }
        return new ApiResponse();
    }

    public UserAuth getByIdentifier(String mobile) {
        UserAuth userAuth = dao.getByIdentifier(mobile);
        return userAuth;
    }

    /**
     * 校验用户
     * @param username
     * @param password
     * @return
     */
    public UserAuth verifyUser(String username, String password) {
        return dao.verifyUser(username, password);
    }

    /**
     * 联合存储
     * @param userAuth
     */
    @Transactional
    public void jointSave(UserAuth userAuth) {
        User user = new User();
        user.setIsInit(UserConstants.USER_IS_INIT_NO);
        user.setLevelType(UserLevelTypeConstants.USER_LEVEL_TYPE_0);
        if(userAuth.getIdentityType() == UserRegisterConstants.register_type_mobile){
            user.setMobile(userAuth.getIdentifier());
        }
        userService.save(user);
        userAuth.setUserId(user.getId());
        save(userAuth);
        UserPoint userPoint = new UserPoint();
        userPoint.setUserId(user.getId());
        userPointService.save(userPoint);
    }

}