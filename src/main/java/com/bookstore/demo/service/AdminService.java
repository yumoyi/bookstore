package com.bookstore.demo.service;

import com.bookstore.demo.po.Admin;

/**
 * @author cy
 * @since 2019-08-30 9:15
 */
public interface AdminService {
    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}