package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Users {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户电话
     */
    private String userPhone;


}