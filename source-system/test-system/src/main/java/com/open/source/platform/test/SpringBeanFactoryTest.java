package com.open.source.platform.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * spring Bean 工厂获取bean测试.
 *
 * @author hanguo
 * @date 2024/8/9
 */

@Component
@Configuration
public class SpringBeanFactoryTest {


    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(defaultListableBeanFactory);
        reader.register(SpringBeanFactoryTest.class);


    }
}
