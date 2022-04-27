package com.open.source.platform.entity;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hanguo
 * @date 2022/1/20
 * @Description 请填写描述信息
 */
public class Test {

   private static Set<User> set =new HashSet<>();

    static {
        User user = new User();
        user.setName("zhangsan");
        set.add(user);

    }

    public static void main1(String[] args) {

        List<User> list = new ArrayList();

        User user = new User();
        user.setId(1L);
        user.setEmail("aaa");
        user.setName("bbb");

        User user1 = new User();
        BeanUtils.copyProperties(user,user1);
        user1.setName("1");
        User user2 = new User();
        BeanUtils.copyProperties(user,user2);
        user2.setName("2");
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println(list.toString());
    }

    public static void main2(String[] args) {
        User user = new User();
        BeanUtils.copyProperties(null,user);
        System.out.println(user);
    }

    public static void main(String[] args) {
        System.out.println(set);
    }



}
