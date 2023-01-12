package com.wusong.cloudonlytraceid.annos;

import com.wusong.cloudonlytraceid.conditional.OnCloudOnlyTraceIdConditional;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author WuSong
 * @version 1.0
 * @date 2023/1/12 16:59
 * @description TraceId开关
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional({ OnCloudOnlyTraceIdConditional.class })
public @interface ConditionalOnCloudOnlyTraceId {
}
