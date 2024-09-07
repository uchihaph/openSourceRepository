package com.open.source.platform.designmodel.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Test {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Proxy proxy = (Proxy) applicationContext.getBean("proxy");
        proxy.functionOne();
        proxy.functionTwo();
        proxy.functionThree();

    }
}
