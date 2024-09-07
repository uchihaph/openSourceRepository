package com.open.source.platform.test.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 测试bean的生命周期
 *
 * @author hanguo
 * @date 2024/8/25
 */
@SpringBootApplication
public class A03ApplicationContext {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(A03ApplicationContext.class, args);
        context.close();

    }

}