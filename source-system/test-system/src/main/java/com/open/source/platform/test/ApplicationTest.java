package com.open.source.platform.test;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import javax.naming.Context;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

/**
 * spring容器测试类.
 *
 * @author hanguo
 * @date 2024/8/14
 */

@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationTest.class, args);

//        Object aaa = context.getBean("aaa");
        System.out.println(context);

        Field singletonobjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonobjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonobjects.get(beanFactory);

        map.forEach((k, v) ->
                System.out.println(k + "=" + v));

        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        Resource[] resources = context.getResources("classpath*:META-INF/spring.factories");
        for (Resource resource : resources) {
            System.out.println(resource);
        }

        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("server.port"));


//        context.publishEvent(new UserRegisteredEvent(context));

        context.getBean(Component1.class).register();
    }


}
