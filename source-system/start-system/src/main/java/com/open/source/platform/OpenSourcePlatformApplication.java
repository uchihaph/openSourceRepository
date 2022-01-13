package com.open.source.platform;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.activation.DataSource;


/**
 * @author hanguo
 * @date 2021/12/27
 * @Description 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.open.source.platform.mapper"})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.open.source.platform"})
public class OpenSourcePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenSourcePlatformApplication.class, args);
    }
}
