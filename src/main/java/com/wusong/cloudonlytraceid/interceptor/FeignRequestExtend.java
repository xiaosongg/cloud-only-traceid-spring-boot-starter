package com.wusong.cloudonlytraceid.interceptor;

import com.wusong.cloudonlytraceid.filter.TraceIdFilter;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 16:29
 * @description
 */
public class FeignRequestExtend implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        String traceId = MDC.get(TraceIdFilter.TRACE_ID);
        template.header(TraceIdFilter.TRACE_ID, traceId);
    }
}
