package com.open.source.platform.test.test01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/7
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        run.close();
    }
//
//    @Bean
//    MyBean myBean() {
//        return new MyBean();
//    }
}
