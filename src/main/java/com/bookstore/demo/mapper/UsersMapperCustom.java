package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cy
 * @since 2019-08-20 8:41
 */
@Mapper
public interface UsersMapperCustom {
    /**
     * 用户登录功能
     * @param users
     * @return users
     */
    Users selectByUser(Users users);

    /**
     * 根据用户名查询用户信息
     * @param users
     * @return users
     */
    Users selectByName(Users users);

    /**
     * 根据用户id查询用户信息
     * @param users
     * @return users
     */
    Users selectById(Users users);
}
