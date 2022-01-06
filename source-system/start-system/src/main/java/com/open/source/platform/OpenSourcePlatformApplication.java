package com.open.source.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author hanguo
 * @date 2021/12/27
 * @Description 启动类
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = {"com.open.source.platform.*"})
public class OpenSourcePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenSourcePlatformApplication.class, args);
    }
}
