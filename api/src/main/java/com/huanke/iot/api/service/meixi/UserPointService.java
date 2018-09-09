package com.huanke.iot.api.service.meixi;

import com.huanke.iot.api.controller.meixi.vo.UserInfoVo;
import com.huanke.iot.api.controller.meixi.vo.UserPointsSeqVo;
import com.huanke.iot.base.dao.meixi.UserPointDao;
import com.huanke.iot.base.dao.meixi.dto.UserPointsSeqDto;
import com.huanke.iot.base.po.UserPoint;
import com.huanke.iot.base.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private UserService userService;

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

    public UserPointsSeqVo getPointsSeq(Integer userId) {
        UserPointsSeqVo userPointsSeqVo = new UserPointsSeqVo();
        UserInfoVo userInfo = userService.getInfo(userId);
        //当前用户信息
        userPointsSeqVo.setCurrentNickname(userInfo.getNickname());
        userPointsSeqVo.setCurrentHeadImg(userInfo.getHeadImg());
        userPointsSeqVo.setCurrentPoints(userInfo.getPoints());
        //排序信息
        List<UserPointsSeqDto> pointsSeqList = getPointsSeqList();
        List<UserPointsSeqVo.UserPointsSeqItem> pointsSeqItems = new ArrayList<>();
        for (UserPointsSeqDto userPointsSeqDto : pointsSeqList) {
            UserPointsSeqVo.UserPointsSeqItem userPointsSeqItem = new UserPointsSeqVo.UserPointsSeqItem();
            BeanUtils.copyProperties(userPointsSeqDto, userPointsSeqItem);
            pointsSeqItems.add(userPointsSeqItem);
        }
        userPointsSeqVo.setUserPointsSeqItems(pointsSeqItems);
        return userPointsSeqVo;
    }

    private List<UserPointsSeqDto> getPointsSeqList() {
        return dao.getPointsSeqList();
    }
}
