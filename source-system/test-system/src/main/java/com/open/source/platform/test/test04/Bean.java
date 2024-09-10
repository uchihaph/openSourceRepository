package com.open.source.platform.test.test04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请描述该类或接口的功能信息.
 *
 * @author hanguo
 * @date 2024/9/10
 */
@Component
public class Bean {

    @Autowired
    private List<Config> configs;

    public List<Config> getConfigs() {
        return configs;
    }
}
