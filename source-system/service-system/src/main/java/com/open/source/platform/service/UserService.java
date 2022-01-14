package com.open.source.platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.open.source.platform.entity.User;
import com.open.source.platform.requestDO.UserDO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
public interface UserService {

    /**
     * 查询用户列表
     *
     * @param userDO
     * @return
     */
    IPage<User> queryUser(UserDO userDO);

    /**
     * 检查登录的用户数据
     *
     * @param userDO
     * @return
     */
    Boolean checkLoginData(UserDO userDO);
}
