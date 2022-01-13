package com.open.source.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hanguo
 * @date 2022/1/14
 * @Description 请填写描述信息
 */
@MapperScan("com.open.source.platform.mapper")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
