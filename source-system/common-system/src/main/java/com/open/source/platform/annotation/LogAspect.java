package com.open.source.platform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hanguo
 * @date 2022/4/27
 * @Description 日志切面
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAspect {

    /**
     * 标识
     *
     * @return
     */
    String remark() default "";

    /**
     * 默认标识值
     *
     * @return
     */
    String value() default "";

    /**
     * 是否打印日志 默认不打印
     *
     * @return
     */
    boolean printLog() default true;

    /**
     * 错误码
     *
     * @return
     */
    String errorCode() default "";

}
