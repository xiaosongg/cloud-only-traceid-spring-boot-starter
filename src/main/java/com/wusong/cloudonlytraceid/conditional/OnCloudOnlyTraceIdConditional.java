package com.wusong.cloudonlytraceid.conditional;

import org.springframework.core.annotation.Order;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 16:57
 * @description
 */
@Order(10)
public class OnCloudOnlyTraceIdConditional extends PropertiesEnabledCondition {

    public OnCloudOnlyTraceIdConditional() {
        // 默认为开启
        super("cloud.only.trace.enabled", true);
    }
}
