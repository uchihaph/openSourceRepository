package com.open.source.platform.controller;


import com.open.source.platform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncTestController {

    @Resource
    private UserService userService;

    @GetMapping("/testA")
    public String testAsync() {

        String field = "nodeA";

        if ("nodeA".equals(field)) {
            Boolean aBoolean = userService.testAsync();
            if (true) {
                return field;
            } else {
                return "false";
            }
        } else {
            return "nodeB";
        }

    }
}
