package com.open.source.platform.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * BeanFactory接口实现.
 *
 * @author hanguo
 * @date 2024/8/24
 */
public class TestBeanFactory {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();
        beanFactory.registerBeanDefinition("config", beanDefinition);

        //给beanFactory添加后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);

        //bean后置处理器 针对bean的生命周期各个阶段提供扩展，例如@Autowire @Resource
        //后置处理器可以设置排序
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().stream().sorted(beanFactory.getDependencyComparator()).forEach(
                e -> {
                    System.out.println(">>>" + e);
                    beanFactory.addBeanPostProcessor(e);
                }
        );

        //调用后置处理器执行其对应逻辑
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(e -> e.postProcessBeanFactory(beanFactory));
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        //执行该代码，则预加载所有的bean，不再是使用到时才加载
        beanFactory.preInstantiateSingletons();
        System.out.println(">>>>>>>>>>>>>>>>>>>>分割线>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(beanFactory.getBean(Bean1.class).getBean2());

        System.out.println(">>>>>>>>>>>>>>>>>>>>分割线>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(beanFactory.getBean(Bean1.class).getInter());

    }

    @Configuration
    static class Config {

        @Bean
        public Bean1 bean1() {
            return new Bean1();
        }

        @Bean
        public Bean2 bean2() {
            return new Bean2();
        }

        @Bean
        public Bean3 bean3() {
            return new Bean3();
        }

        @Bean
        public Bean4 bean4() {
            return new Bean4();
        }

    }


    interface Inter {

    }

    static class Bean3 implements Inter {
    }

    static class Bean4 implements Inter {
    }

    static class Bean1 {

        @Autowired
        Bean2 bean2;

        public Bean1() {

            System.out.println("Bean1 constructor");
        }

        public Bean2 getBean2() {
            return bean2;
        }


        //在不修改后置处理器加入顺序的前提下，这里注入的是'bean3',原因是AutoWire后置处理器优先级高
        @Autowired
        @Resource(name = "bean4")
        private Inter bean3;

        public Inter getInter() {
            return bean3;
        }
    }


    static class Bean2 {

        public Bean2() {
            System.out.println("Bean2 constructor");
        }
    }

}
