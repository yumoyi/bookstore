package com.bookstore.demo.service;

import com.aliyuncs.exceptions.ClientException;
import com.bookstore.demo.po.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-20 8:04
 */
public interface UserService {

    /**
     * 用户登录
     * @param users
     * @return 用户信息
     */
    Users login(Users users);

    /**
     * 用户注册
     * @param users
     * @return 判断是否注册成功
     */
    Integer register(Users users);


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
     * 修改用户信息
     * @param users
     * @return 判断是否修改成功
     */
    Integer update(Users users);

    /**
     * 生成手机验证码
     * @param telephone
     * @return 验证码
     */
    String createSmsCode(String telephone) throws ClientException;

    /**
     * 收货人查询
     * @param userId
     * @return 收货人信息
     */
    List<Address> userAddress(Integer userId);

    /**
     * 统计有多少用户
     * @param usersExample
     * @return 用户总数
     */
    Integer countUsers(UsersExample usersExample);

    /**
     * 收货人id查询收货人信息
     * @param orderId
     * @return 收货人信息
     */
    Orders selectAddress(String orderId);
}
