package com.open.source.platform.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 组件1.
 *
 * @author hanguo
 * @date 2024/8/24
 */
@Component
public class Component1 {

    @Autowired
    private ApplicationEventPublisher context;

    public void register() {
        System.out.println("用户注册");
        context.publishEvent(new UserRegisteredEvent(this));
    }
}
