package com.wusong.cloudonlytraceid.config;

import com.wusong.cloudonlytraceid.conditional.OnCloudOnlyTraceIdConditional;
import com.wusong.cloudonlytraceid.properties.CloudOnlyTraceIdProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 17:07
 * @description
 */
@Configuration
@Conditional(OnCloudOnlyTraceIdConditional.class)
@EnableConfigurationProperties(CloudOnlyTraceIdProperties.class)
public class EnabledCloudOnlyTraceIdAutoConfiguration {

}
