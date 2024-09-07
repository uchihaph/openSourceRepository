package com.open.source.platform.designmodel.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("appConfigProxy")
public class AppConfig {

    @Bean
    public Subject subject() {
        return new Subject();
    }

    @Bean
    public Proxy proxy() {
        return new Proxy();
    }
}
