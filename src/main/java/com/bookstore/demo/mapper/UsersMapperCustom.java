package com.bookstore.demo.mapper;

import com.bookstore.demo.po.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 8:41
 */
@Mapper
public interface UsersMapperCustom {
    /**
     * 用户登录功能
     * @param users
     * @return 用户信息
     */
    Users selectByUser(Users users);

    /**
     * 根据用户名查询用户信息
     * @param users
     * @return 用户信息
     */
    Users selectByName(Users users);

    /**
     * 根据用户id查询用户信息
     * @param users
     * @return 用户信息
     */
    Users selectById(Users users);

    /**
     * 后台查询用户信息(包含用户名搜索)
     * @param users
     * @return 用户信息
     */
    List<Users> findAllByUsers(Users users);
}
