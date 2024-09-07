package com.open.source.platform.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main1(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("useService"));
//        System.out.println(applicationContext.getBean("useService"));
//        System.out.println(applicationContext.getBean("useService"));
//        System.out.println(applicationContext.getBean("appConfig"));

    }

    public static void main(String[] args) {

    }
}
