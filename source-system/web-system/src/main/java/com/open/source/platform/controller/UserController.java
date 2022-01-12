package com.open.source.platform.controller;

import com.open.source.platform.dao.UserDO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanguo
 * @date 2022/1/12
 * @Description 请填写描述信息
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String userLogin(UserDO user){
        return "登录成功";
    }
}
