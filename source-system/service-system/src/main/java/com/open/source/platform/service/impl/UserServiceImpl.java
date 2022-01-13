package com.open.source.platform.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.open.source.platform.entity.User;
import com.open.source.platform.mapper.UserMapper;

import com.open.source.platform.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
