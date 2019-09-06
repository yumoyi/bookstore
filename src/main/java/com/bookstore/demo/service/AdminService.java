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
     * @return 管理员信息
     */
    Admin login(Admin admin);

    /**
     * 管理员修改密码
     * @param admin
     */
     void update(Admin admin);
}
