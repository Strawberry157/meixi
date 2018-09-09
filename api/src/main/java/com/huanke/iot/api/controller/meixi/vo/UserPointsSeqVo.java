package com.huanke.iot.api.controller.meixi.vo;

import lombok.Data;

import java.util.List;

/**
 * 描述:
 * 用户积分排序vo
 *
 * @author onlymark
 * @create 2018-09-09 上午9:08
 */
@Data
public class UserPointsSeqVo {
    private List<UserPointsSeqItem> userPointsSeqItems;
    private String currentNickname;
    private String currentHeadImg;
    private Integer currentPoints;

    @Data
    public static class UserPointsSeqItem{
        private String nickname;
        private String headImg;
        private String bgImg;
        private Integer points;
    }

}
