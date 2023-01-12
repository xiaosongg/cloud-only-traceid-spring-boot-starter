package com.wusong.cloudonlytraceid.config;

import com.wusong.cloudonlytraceid.annos.ConditionalOnCloudOnlyTraceId;
import com.wusong.cloudonlytraceid.filter.TraceIdFilter;
import com.wusong.cloudonlytraceid.interceptor.FeignRequestExtend;
import com.wusong.cloudonlytraceid.interceptor.TraceIdInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 16:36
 * @description
 */
@Configuration
@ConditionalOnCloudOnlyTraceId
@ConditionalOnProperty(value = "cloud.only.trace.enabled", havingValue = "true")
public class CloudOnlyTraceIdAutoConfiguration {

    @Bean
    public FeignRequestExtend createFeignRequestExtend(){
        return new FeignRequestExtend();
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public TraceIdFilter createTraceIdFilter(){
        return new TraceIdFilter();
    }

    @Bean
    public TraceIdInterceptor createTraceIdInterceptor(){
        return new TraceIdInterceptor();
    }

}
