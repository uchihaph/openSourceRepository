package com.open.source.platform.designmodel.proxy;

import org.springframework.stereotype.Component;

public class Subject implements ProxyInfc {


    @Override
    public void functionOne() {
        System.out.println("实现功能1");
    }

    @Override
    public void functionTwo() {
        System.out.println("实现功能2");

    }

    @Override
    public void functionThree() {
        System.out.println("实现功能3");

    }
}
