package com.open.source.platform.config;

import com.open.source.platform.service.impl.UserServiceImpl;
import com.open.source.platform.test.DITestService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {

    @Bean
    public DITestService getDiTestService1() {
        return new DITestService(1);
    }

    @Bean
    public DITestService getDiTestService2() {
        return new DITestService(2);
    }
}
