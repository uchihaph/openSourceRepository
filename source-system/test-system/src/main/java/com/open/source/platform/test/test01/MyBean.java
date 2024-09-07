package com.open.source.platform.test.test01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/7
 */
@Component
public class MyBean implements BeanNameAware, InitializingBean {
    @Override
    public void setBeanName(String name) {

        System.out.println("BeanNameAware");
    }

    @PostConstruct
    public void init() {

        System.out.println("PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

}
