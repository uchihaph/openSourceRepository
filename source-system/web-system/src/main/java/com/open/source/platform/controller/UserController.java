package com.open.source.platform.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.source.platform.ResponseCodeEnum;
import com.open.source.platform.entity.User;
import com.open.source.platform.requestDO.UserDO;
import com.open.source.platform.service.UserService;
import com.open.source.platform.struct.result.Result;
import com.open.source.platform.test.DITestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author hanguo
 * @date 2022/1/12
 * @Description 用戶
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private static Log log = LogFactory.getLog(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private DITestService getDiTestService1;

    @PostMapping("/login")
    public Result userLogin(@RequestBody UserDO userDo) {

        log.info("用户登录操作：" + JSONObject.toJSONString(userDo));

        if (Objects.isNull(userDo) || StringUtils.isEmpty(userDo.getUsername()) || StringUtils.isEmpty(userDo.getPassword())) {
            throw new RuntimeException("PLEASE_INPUT_USERNAME_AND_PASSWORD");
        }

        Boolean loginResult = userService.checkLoginData(userDo);
        if (loginResult) {

            return new Result(true, ResponseCodeEnum.SUCCESS.getCode(), "登录成功");
        }
        return new Result(false, ResponseCodeEnum.FAIL.getCode(), "用户名或密码输入错误");

    }

    @PostMapping("/queryUser")
    public Result<List<User>> queryUserList(@RequestBody UserDO userDo) {

        log.info("查询用户操作：" + JSONObject.toJSONString(userDo));
        Result<List<User>> result = Result.success(new ArrayList<>());

        IPage<User> users = userService.queryUser(userDo);
        if (Objects.isNull(users)) {
            result.setTotal(0);
        }

        result.setResult(users.getRecords());
        result.setTotal(users.getTotal());
        return result;
    }


    @GetMapping("/distinct")
    public Result<List<User>> distinct() {
        List<User> users = userService.queryDistinct("是否");
        return Result.success(users);
    }


    @GetMapping("/testDi")
    public Result<String> testDi() {

        getDiTestService1.printName();
        return Result.success("测试di");
    }
}
