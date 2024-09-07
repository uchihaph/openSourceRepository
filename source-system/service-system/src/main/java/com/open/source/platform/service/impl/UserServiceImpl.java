package com.open.source.platform.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.source.platform.entity.User;
import com.open.source.platform.mapper.UserMapper;
import com.open.source.platform.requestDO.UserDO;
import com.open.source.platform.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
@Service
public class UserServiceImpl implements UserService , InitializingBean {

    @Resource
    private UserMapper userMapper;




    @Override
    public IPage<User> queryUser(UserDO userDO) {
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


//        QueryWrapper<User> userWrapper = new QueryWrapper<>();
//        userWrapper.eq(false, "username", userDO.getUsername());
//        userWrapper.eq(false, "password", userDO.getPassword());
//        userWrapper.eq(false, "telephone", userDO.getTelephone());
//        userWrapper.eq(false, "nick", userDO.getNick());
//        userWrapper.like(false, "name", userDO.getName());
//
//        return userMapper.selectPage(new Page<User>(userDO.getPageNumber(), userDO.getPageSize()), userWrapper);

        return userMapper.selectUserPageByCondition(new Page<>(userDO.getPageNumber(), userDO.getPageSize()), userDO);

    }

    public Boolean checkLoginData(UserDO userDO) {
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq(true, "username", userDO.getUsername());
        userWrapper.eq(true, "password", userDO.getPassword());
        List<User> users = userMapper.selectList(userWrapper);
        if (!CollectionUtils.isEmpty(users)) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> queryDistinct(String name) {
        return userMapper.selectDistinct(name);
    }

    @Override
    @Async
    public Boolean testAsync() {
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean初始化");
    }
}
