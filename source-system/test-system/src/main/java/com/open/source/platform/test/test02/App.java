package com.open.source.platform.test.test02;

import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/9
 */
public class App {
    public static void main(String[] args) {

        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean("config", Config.class);
        applicationContext.registerBean(ConfigurationClassPostProcessor.class);
        applicationContext.refresh();

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }

    }
}
