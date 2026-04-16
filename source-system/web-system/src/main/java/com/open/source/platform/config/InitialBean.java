package com.open.source.platform.config;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;


public class InitialBean implements InitializingBean {

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");

    }

    public void initialMethod(){
        System.out.println("initialMethod");
    }

    public String printHello(){
        return "hello";
    }
}
