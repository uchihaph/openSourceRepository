package com.open.source.platform.test;

import org.springframework.context.ApplicationEvent;

/**
 * 用户自定义事件注册器.
 *
 * @author hanguo
 * @date 2024/8/24
 */
public class UserRegisteredEvent extends ApplicationEvent {


    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisteredEvent(Object source) {
        super(source);
    }
}
