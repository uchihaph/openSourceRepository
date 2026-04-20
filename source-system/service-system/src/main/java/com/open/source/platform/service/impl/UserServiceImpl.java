package com.open.source.platform.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.source.platform.entity.User;
import com.open.source.platform.mapper.UserMapper;
import com.open.source.platform.requestDO.UserDO;
import com.open.source.platform.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    @Lazy
    private UserServiceImpl userService;


    @Override
    public List<User> queryUser(UserDO userDO) {

        if (Objects.isNull(userDO)) {
            return null;
        }

        if (Objects.isNull(userDO.getPageNumber())) {
            userDO.setPageNumber(0);
        }
        if (Objects.isNull(userDO.getPageSize())) {
            userDO.setPageSize(20);
        }
        if (Objects.isNull(userDO.getStart())) {
            userDO.setStart(0);
        }
        if (Objects.isNull(userDO.getLimit())) {
            userDO.setLimit(20);
        }


        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq(false, "username", userDO.getUsername());
        userWrapper.eq(false, "password", userDO.getPassword());
        userWrapper.eq(false, "telephone", userDO.getTelephone());
        userWrapper.eq(false, "nick", userDO.getNick());
        userWrapper.like(false, "name", userDO.getName());


        return userMapper.selectUser(null);

    }

    public Boolean checkLoginData(UserDO userDO) {
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq(true, "username", userDO.getUsername());
        userWrapper.eq(true, "password", userDO.getPassword());
        List<User> users = userMapper.selectUser(null);
        if (!CollectionUtils.isEmpty(users)) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> queryDistinct(String name) {
        return userMapper.selectUser(name);
    }

    @Override
    @Async
    public Boolean testAsync() {
        return false;
    }

    @Override
    @Transactional
    public void operatedDb() {

        userMapper.deleteUser(1L);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            userService.deleteLs();
        });
        try {
            future.get();
        } catch (Exception e) {
            log.error("子线程出现异常");
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void deleteLs() {
        userMapper.deleteUser(2L);
        throw new RuntimeException("测试删除失败");
    }

}
