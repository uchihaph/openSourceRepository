package com.open.source.platform.test.test01;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/7
 */
public class Config {
    public static void main(String[] args) {
        GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        genericApplicationContext.registerBean("myBean", MyBean.class);
        genericApplicationContext.refresh();
        genericApplicationContext.close();
    }
}
