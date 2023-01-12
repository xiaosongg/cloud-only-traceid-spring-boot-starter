package com.wusong.cloudonlytraceid.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 17:05
 * @description
 */
@ConfigurationProperties(prefix = "cloud.only.trace")
public class CloudOnlyTraceIdProperties {

    /**
     * 是否开启全局唯一traceId
     */
    private boolean enabled = false;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
