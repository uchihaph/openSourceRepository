package com.open.source.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @author hanguo
 * @date 2021/12/27
 * @Description 启动类
 */
//@SpringBootApplication(scanBasePackages = {"com.open.source.platform"})
@SpringBootConfiguration
@ComponentScan
@MapperScan(basePackages = {"com.open.source.platform.mapper"})
@EnableAsync
@EnableAutoConfiguration
public class OpenSourcePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenSourcePlatformApplication.class, args);
    }


}
