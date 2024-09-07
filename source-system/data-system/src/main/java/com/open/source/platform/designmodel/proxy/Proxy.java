package com.open.source.platform.designmodel.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Proxy implements ProxyInfc {

    @Autowired
    private Subject subject;


    @Override
    public void functionOne() {
        subject.functionOne();
    }

    @Override
    public void functionTwo() {
        subject.functionTwo();
    }

    @Override
    public void functionThree() {
        subject.functionThree();
    }
}
