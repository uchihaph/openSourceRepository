package com.open.source.platform.spring;

import com.open.source.platform.spring.service.OrderService;
import com.open.source.platform.spring.service.UseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {

    @Bean
    public UseService useService() {
        return new UseService();
    }


    @Bean
    public OrderService orderService() {
        System.out.println(useService());
        System.out.println(useService());
        return new OrderService();
    }


}
