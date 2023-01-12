package com.wusong.cloudonlytraceid.filter;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 16:28
 * @description
 */
public class TraceIdFilter implements Filter {

    public final static String TRACE_ID = "traceId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String traceId = httpRequest.getHeader(TRACE_ID);
        if (!StringUtils.hasLength(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
        MDC.put(TRACE_ID, traceId);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader(TRACE_ID, traceId);
        chain.doFilter(request, response);

    }
}
