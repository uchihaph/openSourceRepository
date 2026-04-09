package com.open.source.platform.mapper;

import com.open.source.platform.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hanguo
 * @since 2022-01-13
 */
@Mapper
public interface UserMapper {

    List<User> selectUser(String name);

    void deleteUser(Long id);
}