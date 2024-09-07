package com.open.source.platform.spring.aop;

import org.springframework.stereotype.Component;


public class UserService {

    private OrderService orderService;

    public void test(){
        System.out.println(orderService);
    }
}
