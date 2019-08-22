package com.bookstore.demo.service;

import com.aliyuncs.exceptions.ClientException;
import com.bookstore.demo.po.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @author cy
 * @since 2019-08-20 8:04
 */
public interface UserService {

    /**
     * 用户登录
     * @param users
     * @return users
     */
    Users login(Users users);

    /**
     * 用户注册
     * @param users
     * @return users
     */
    Integer register(Users users);


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

    /**
     * 修改用户信息
     * @param users
     * @return integer
     */
    Integer update(Users users);

    /**
     * 生成手机验证码
     * @param telephone
     * @return code
     */
    String createSmsCode(String telephone) throws ClientException;
}
