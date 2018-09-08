package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.request.UserInfoRequest;
import com.huanke.iot.api.controller.meixi.vo.UserInfoVo;
import com.huanke.iot.base.dao.meixi.UserDao;
import com.huanke.iot.base.po.User;
import com.huanke.iot.base.po.UserPoint;
import com.huanke.iot.base.service.CrudService;
import com.huanke.iot.base.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * 用户个人信息service类
 *
 * @author onlymark
 * @create 2018-09-08 上午10:45
 */
@Service
@Slf4j
public class UserService extends CrudService<UserDao, User> {
    @Autowired
    private UserPointService userPointService;
    /**
     * 完善个人信息
     *
     * @param userId
     * @param request
     * @param remoteAddress
     * @return
     */
    public void perfectInfo(Integer userId, UserInfoRequest request, String remoteAddress) {
        User user = get(userId);
        user.setSex(request.getSex());
        user.setBirthDate(request.getBirthDate());
        user.setSkinType(request.getSkinType());
        user.setAge(DateUtils.getAgeByBirth(request.getBirthDate()));
        save(user);
    }

    /**
     * 获取个人信息
     * @param userId
     * @return
     */
    public UserInfoVo getInfo(Integer userId) {
        UserInfoVo userInfoVo = new UserInfoVo();
        User user = get(userId);
        UserPoint userPoint = userPointService.getByUserId(userId);
        BeanUtils.copyProperties(user, userInfoVo);
        BeanUtils.copyProperties(userPoint, userInfoVo);
        return userInfoVo;
    }

}
