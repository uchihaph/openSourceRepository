package com.open.source.platform.requestDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author hanguo
 * @date 2021/12/27
 * @Description 请填写描述信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 电话号码
     */
    private String telephone;


    /**
     * 分页参数
     */
    private Integer start;

    /**
     * 分页大小
     */
    private Integer limit;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 页数
     */
    private Integer pageSize;
}
