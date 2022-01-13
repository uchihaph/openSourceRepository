package com.open.source.platform.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.open.source.platform.entity.User;
import com.open.source.platform.requestDO.UserDO;
import com.open.source.platform.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.List;
import java.util.Objects;

/**
 * @author hanguo
 * @date 2022/1/12
 * @Description 请填写描述信息
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @PostMapping("/login")
    public String userLogin(UserDO userDo) {
        if (Objects.isNull(userDo) || StringUtils.isEmpty(userDo.getUsername()) || StringUtils.isEmpty(userDo.getPassword())) {
            return "请输入用户名和密码";
        }

        Wrapper<User> wrapper = new Condition();
        wrapper.eq("username", userDo.getUsername());
        wrapper.eq("password", userDo.getPassword());
        List<User> users = iUserService.selectList(wrapper);
        if (!CollectionUtils.isEmpty(users)) {
            return "登录成功";
        } else {
            return "用户名或者密码错误";
        }
    }

    @PostMapping("/queryUser")
    public Page<User> queryUserList(UserDO userDo) {
        Page<User> userPage = iUserService.selectPage(new Page<>(0, 10));

        return userPage;
    }

}
