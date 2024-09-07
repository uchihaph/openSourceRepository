package com.open.source.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.open.source.platform.entity.User;
import com.open.source.platform.requestDO.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectUserPageByCondition(IPage<User> iPage, @Param("userDO") UserDO userDO);

    List<User> selectDistinct(String name);
}