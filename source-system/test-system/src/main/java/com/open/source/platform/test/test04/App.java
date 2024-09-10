package com.open.source.platform.test.test04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/10
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getBean(Bean.class).getConfigs());
    }
}
