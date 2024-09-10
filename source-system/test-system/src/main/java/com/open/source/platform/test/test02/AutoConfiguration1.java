package com.open.source.platform.test.test02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/9
 */
@Configuration
public class AutoConfiguration1 {

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

}
