package com.huanke.iot.base.app;

import lombok.Data;

/**
 * @author haoshijing
 * @version 2018年06月13日 11:24
 **/

@Data
public class AppIdInfo {
    /**
     * appId
     */
    private String appId;
    /**
     * app密钥
     */
    private String appSecret;
}
