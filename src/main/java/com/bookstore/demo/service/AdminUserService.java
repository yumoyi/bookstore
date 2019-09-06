package com.bookstore.demo.service;

import com.bookstore.demo.po.Users;
import com.github.pagehelper.PageInfo;

/**
 * @author cy
 * @since 2019-08-28 23:32
 */
public interface AdminUserService {

    /**
     * 用户信息查询
     * @param users
     * @param page
     * @param size
     * @return 带分页的用户信息
     */
    PageInfo<Users> findAllByPage(Users users, int page, int size);

}
