package com.open.source.platform.test.beanlifecycle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 生命周期bean
 *
 * @author hanguo
 * @date 2024/8/26
 */
@Component
public class LifeCycleBean {

    public LifeCycleBean() {
        System.out.println("构造");
    }

    @Autowired
    public void autowire(@Value("${JAVA_HOME)") String home) {

        System.out.println("依赖注入：" + home);
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁");
    }

}
