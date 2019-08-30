package com.bookstore.demo.service.serviceimpl;

import com.bookstore.demo.mapper.UsersMapperCustom;
import com.bookstore.demo.po.Users;
import com.bookstore.demo.service.AdminUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cy
 * @since 2019-08-28 23:35
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private UsersMapperCustom usersMapperCustom;


    /**
     * 用户信息查询
     *
     * @param users
     * @param page
     * @param size
     * @return users
     */
    @Override
    public PageInfo<Users> findAllByPage(Users users, int page, int size) {

        PageHelper.startPage(page,size);
        List<Users> allByUsers = usersMapperCustom.findAllByUsers(users);
        PageInfo<Users> pageInfo = new PageInfo<>(allByUsers);

        return pageInfo;

    }
}
