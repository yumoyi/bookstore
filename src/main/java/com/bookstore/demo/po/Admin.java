package com.bookstore.demo.po;

import lombok.Data;

/**
 * @author cy
 */
@Data
public class Admin {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员名称
     */
    private String adminName;

    /**
     * 管理员密码
     */
    private String adminPassword;


}