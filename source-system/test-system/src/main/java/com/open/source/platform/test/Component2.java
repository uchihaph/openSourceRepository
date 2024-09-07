package com.open.source.platform.test;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 组件2.
 *
 * @author hanguo
 * @date 2024/8/24
 */
@Component
public class Component2 {

    @EventListener
    public void eventListener(UserRegisteredEvent event) {

        System.out.println(event);

        System.out.println("发送短信");

    }
}
